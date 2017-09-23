package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 5/4/15. codeashobby@gmail.com
 */
public class PowX {

    public double myPow(double x, int n) {
        boolean isNeg = n < 0;
        long m = Math.abs((long) n);
        double result = 1;
        while (m > 0) {
            if ((m & 1) == 1) {
                result *= x;
            }
            x *= x;
            m = m >> 1;
        }
        return isNeg ? (1 / result) : result;
    }
}
