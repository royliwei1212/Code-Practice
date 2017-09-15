package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/15/17
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return integerReplacement(n / 2) + 1;
        long x = n;
        return Math.min(integerReplacement((int) ((x + 1) / 2)), integerReplacement((int) ((x - 1) / 2))) + 2;
    }
}
