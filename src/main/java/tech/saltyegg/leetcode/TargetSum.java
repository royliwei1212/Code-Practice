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

    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        int t = sum + S;
        if (t % 2 != 0 || S > sum) return 0;
        t = t / 2;

        int[] dp = new int[t + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = t; i >= n; i--) {
                dp[i] = dp[i] + dp[i - n];
            }
        }
        return dp[t];
    }

}
