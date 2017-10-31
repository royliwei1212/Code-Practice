package tech.saltyegg.leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || nums.length < m) return 0;

        int[][] dp = new int[m + 1][nums.length + 1];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[0][0] = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + nums[i - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= nums.length; j++) {
                for (int k = i - 1; k < j; k++) {
                    int val = Math.max(dp[i - 1][k], sum[j] - sum[k]);
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }

        return dp[m][nums.length];
    }
}
