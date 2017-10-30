package tech.saltyegg.leetcode;

public class DecodeWaysII {

    public int numDecodings(String s) {
        int M = 1000000007;
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i < dp.length; i++) {
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i - 2);
            if (c1 == '0') {
                if (c2 == '0') {
                    return 0;
                } else if (c2 == '*') {
                    dp[i] += 2 * dp[i - 2];
                } else if (c2 == '1' || c2 == '2') {
                    dp[i] += dp[i - 2];
                }
            } else if (c1 >= '1' && c1 <= '9') {
                dp[i] += dp[i - 1];
                if (c2 == '1' || c2 == '2' && c1 <= '6') {
                    dp[i] += dp[i - 2];
                } else if (c2 == '*') {
                    dp[i] += (c1 <= '6') ? 2 * dp[i - 2] : dp[i - 2];
                }
            } else { // c1 == '*'
                dp[i] += 9 * dp[i - 1];
                if (c2 == '1') {
                    dp[i] += 9 * dp[i - 2];
                } else if (c2 == '2') {
                    dp[i] += 6 * dp[i - 2];
                } else if (c2 == '*') {
                    dp[i] += 15 * dp[i - 2];
                }
            }
            dp[i] %= M;
        }

        return (int) dp[s.length()];
    }
}
