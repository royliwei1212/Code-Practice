package tech.saltyegg.java;

import com.relops.snowflake.Snowflake;

/**
 * @author hzhou
 * @since 10/18/17
 */
public class IDGenerator {
    public static void main(String[] args) {
        int node = 1;
        Snowflake s = new Snowflake(node);
        int count = 30;
        while (count > 0) {
            System.out.println(s.next());
            count--;
        }
    }
}
