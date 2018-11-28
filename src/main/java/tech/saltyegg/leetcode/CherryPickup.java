package tech.saltyegg.leetcode;

/**
 * Wo TM one face meng B
 */
public class CherryPickup {

    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length + 1;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[1][1][1] = grid[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    int l = i + j - k;
                    if (l < 1 || l >= n || dp[i][j][k] > 0 || grid[i - 1][j - 1] == -1 || grid[k - 1][l - 1] == -1)
                        continue;
                    int max = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], Math.max(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1])));
                    if (max < 0) continue;
                    dp[i][j][k] = max + grid[i - 1][j - 1];
                    if (i != k) dp[i][j][k] += grid[k - 1][l - 1];
                }
            }
        }

        return Math.max(0, dp[n - 1][n - 1][n - 1]);
    }

}
