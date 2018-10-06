package tech.saltyegg.dp.prototype;

/**
 * Description:
 *
 * @author hzhou
 */
public class PrototypeClass implements Cloneable {

    @Override
    public PrototypeClass clone() {
        PrototypeClass cloned = null;
        try {
            cloned = (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            //e.printStackTrace();
        }
        return cloned;
    }
}