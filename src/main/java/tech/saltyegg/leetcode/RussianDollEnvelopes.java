package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 8/30/17
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i++) dp[i] = 1;
        int result = 1;
        for (int i = 1; i < envelopes.length; i++) {
            int[] crt = envelopes[i];
            for (int j = 0; j < i; j++) {
                int[] pre = envelopes[j];
                if (crt[0] > pre[0] && crt[1] > pre[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
