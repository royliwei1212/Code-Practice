package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 4/24/15. codeashobby@gmail.com
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }

        int result = 0;
        long factor = 5;

        while (n / factor > 0) {
            result += n / factor;
            factor *= 5;
        }

        return result;
    }
}
