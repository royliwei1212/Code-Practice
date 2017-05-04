package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/11.
 * Email: i@hzhou.me
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (0x55555555 & num) != 0;
    }
}
