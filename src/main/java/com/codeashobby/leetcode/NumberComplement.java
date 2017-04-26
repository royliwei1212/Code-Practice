package com.codeashobby.leetcode;

/**
 * @author hzhou
 * @since 4/25/17
 */
public class NumberComplement {

    public int findComplement(int num) {
        double x = Math.log(num) / Math.log(2);
        int length = (int) Math.floor(x);
        int result = 0;
        for (int i = 0; i < length; i++) {
            int mask = 1 << i;
            if ((num & mask) > 0) {
                result += mask;
            }
        }
        return result;
    }

}
