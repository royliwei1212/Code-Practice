package tech.saltyegg.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author hzhou
 * @since 9/21/17
 */
public class SerializeExample implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int INDEX = 10;
    private String name;

    public SerializeExample() {
        System.out.println("Paramless Constructor is called...");
        name = "SaltyEgg";
    }

    public SerializeExample(String name) {
        System.out.println("Constructor is called...");
        this.name = name;
    }

    @Override
    public String toString() {
        return "SerializeExample{" +
                "name='" + name + '\'' + ", INDEX= " + INDEX +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeExample se = new SerializeExample("Hello World");
        System.out.println(se);

        // write object to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"))) {
            oos.writeObject(se);
        }

        SerializeExample.INDEX = 20;
        //Read Obj from File
        File file = new File("tempFile");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            SerializeExample se1 = (SerializeExample) ois.readObject();
            System.out.println(se1);
        }

        file.delete();

    }
}
