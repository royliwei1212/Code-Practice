package tech.saltyegg.leetcode;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * For example:
 * <p>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * <p>
 * Created by hzhou on 2016/5/4.
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }

        int divide = 1;
        if (x % 2 == 0) {
            for (int i = 1; i < 32; i++) {
                divide *= 2;
                if ((x & divide) > 0) {
                    break;
                }
            }
        }
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if ((i & divide) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
