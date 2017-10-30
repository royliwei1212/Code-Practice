package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int sum = Arrays.stream(nums).sum();
        if (sum < S || (sum - S) % 2 != 0) return 0;

        int target = (sum - S) / 2;
        int[] result = new int[]{0};

        helper(0, nums, target, result);
        return result[0];
    }

    private void helper(int start, int[] nums, int target, int[] result) {
        if (target == 0) result[0]++; // no return here

        for (int i = start; i < nums.length; i++) {
            int t = target - nums[i];
            if (t < 0) continue;
            helper(i + 1, nums, t, result);
        }
    }

}
