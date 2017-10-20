/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

/**
 * Description:
 *
 * @author hzhou
 */
@SuppressWarnings("Duplicates")
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;

        long l = Math.abs((long) dividend);
        long r = Math.abs((long) divisor);
        int result = 0;
        while (l >= r) {
            int cnt = 0;
            while (l >= (r << cnt)) {
                cnt++;
            }
            result += 1 << (cnt - 1);
            l -= r << (cnt - 1);
        }

        return (dividend > 0 ^ divisor > 0) ? -result : result;
    }
}