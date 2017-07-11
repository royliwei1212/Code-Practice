package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 7/11/17
 */
public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        if (c == 0) return true;
        for (int i = 0; i < Math.sqrt(c); i++) {
            int x = c - i * i;
            int a = (int) Math.sqrt(x);
            if (a * a == x) {
                return true;
            }
        }
        return false;
    }

}
