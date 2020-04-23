package tech.saltyegg.lintcode;

import org.junit.Test;

public class StrangePrinter {

    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = dp[j + 1][i] + 1;
                for (int k = j + 1; k <= i; k++) {
                    if (s.charAt(j) == s.charAt(k)) {
                        dp[j][i] = Math.min(dp[j][i], dp[j + 1][k - 1] + dp[k][i]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    @Test
    public void test() {
        System.out.println(new StrangePrinter().strangePrinter("adeffffv"));
    }
}

