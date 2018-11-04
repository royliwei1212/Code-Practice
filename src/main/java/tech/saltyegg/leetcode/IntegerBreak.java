package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/21.
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, j * (i - j)));
            }
        }
        return dp[n];
    }

}
