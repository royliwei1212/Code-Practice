package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * Created by hzhou on 2016/5/4.
 * Email: i@hzhou.me
 */
public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0 || costs[0].length == 1 && costs.length > 1)
            return 0;
        if (costs[0].length == 1 && costs.length == 1) return costs[0][0];
        int[][] dp = new int[costs.length + 1][costs[0].length];
        for (int i = 1; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0].length; k++) {
                    if (j == k) continue;
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][k] + costs[i][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int n : dp[costs.length]) {
            result = Math.min(result, n);
        }
        return result;
    }

    // less time & memory
    public int minCostII2(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null ||
                costs[0].length == 0 || costs[0].length == 1 && costs.length > 1) return 0;

        if (costs[0].length == 1 && costs.length == 1) return costs[0][0];

        int min1 = 0, min2 = 0, idx = -1;
        for (int[] c : costs) {
            int m1 = Integer.MAX_VALUE;
            int m2 = m1;
            int id = -1;
            for (int j = 0; j < costs[0].length; j++) {
                int cost = c[j] + (j == idx ? min2 : min1);
                if (cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    id = j;
                } else if (cost < m2) {
                    m2 = cost;
                }
            }
            min1 = m1;
            min2 = m2;
            idx = id;
        }
        return min1;
    }
}
