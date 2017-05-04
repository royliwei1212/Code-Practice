package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 4/24/17
 */
public class Base7 {

    public String convertToBase7(int num) {

        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = Math.abs(num);
        }

        int a = num;

        while (a >= 7) {
            int b = a % 7;
            a = a / 7;
            sb.insert(0, b);
        }
        sb.insert(0, a);
        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Base7 b = new Base7();
        System.out.println(b.convertToBase7(100));
        System.out.println(b.convertToBase7(-7));
    }
}
