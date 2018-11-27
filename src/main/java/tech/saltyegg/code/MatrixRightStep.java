package tech.saltyegg.code;

import org.junit.Test;

public class MatrixRightStep {

    public int count(int m, int n) {
        int[][] dp = new int[m][n];
        int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    dp[x][y] += dp[i][j];
                }
            }
        }
        return dp[0][n - 1];
    }

    @Test
    public void test() {
        System.out.println(count(2, 3));
        System.out.println(count(2, 4));
        System.out.println(count(3, 3));
    }
}
