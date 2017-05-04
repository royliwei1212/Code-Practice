package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/4.
 * Email: i@hzhou.me
 */
public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int h = costs.length;
        int c = costs[0].length;

        int[][] dp = new int[h][c];

        System.arraycopy(costs[0], 0, dp[0], 0, c);

        for (int i = 1; i < h; i++) {
            for (int j = 0; j < c; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < c; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < c; i++) {
            min = Math.min(min, dp[h - 1][i]);
        }

        return min;
    }
}
