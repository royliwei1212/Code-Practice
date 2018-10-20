package tech.saltyegg.leetcode;

import org.junit.Test;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] n = new int[len];
        n[0] = n[len - 1] = 1;
        for (int i = 1; i < len - 1; ++i) n[i] = nums[i - 1];
        int[][] dp = new int[len][len];
        for (int k = 2; k < len; ++k) // length of subarray
            for (int l = 0; l < len - k; ++l) { // left
                int r = l + k; // right
                for (int i = l + 1; i < r; ++i)
                    dp[l][r] = Math.max(dp[l][r], n[l] * n[i] * n[r] + dp[l][i] + dp[i][r]);
            }
        return dp[0][len - 1];
    }

    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{5, 1, 3}));
    }
}
