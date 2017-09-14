package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int result = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            result += nums[r--] - nums[l++];
        }
        return result;
    }
}
