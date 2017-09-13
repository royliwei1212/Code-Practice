package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/12/17
 */
public class Remove9 {

    public int newInteger(int n) {
        int result = 0;
        int b = 1;
        while (n > 0) {
            result = result + b * (n % 9);
            n /= 9;
            b *= 10;
        }
        return result;
    }

}
