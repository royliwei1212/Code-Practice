package com.codeashobby.leetcode;

/**
 * Created by hzhou on 2016/5/11.
 * Email: i@hzhou.me
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n * k == 0 || n > 2 && k == 1) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;

        for (int i = 2; i < n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
