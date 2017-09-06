package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzhou
 * @since 9/5/17
 */
public class CoinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        if (A == null || A.length == 0 || A[A.length - 1] == -1 || B == 0) {
            return new ArrayList<>();
        }

        int MAX = 100000; // large enough
        int length = A.length;
        List<Integer> result = new ArrayList<>();
        int[] dp = new int[length];
        int[] pre = new int[length];
        for (int i = 0; i < length; i++) {
            pre[i] = -1;
            dp[i] = MAX;
        }
        dp[length - 1] = A[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (A[i] == -1) continue;
            for (int j = 1; j <= B; j++) {
                if (i + j < length && dp[i + j] + A[i] < dp[i]) {
                    dp[i] = dp[i + j] + A[i];
                    pre[i] = i + j;
                }
            }
        }

        if (dp[0] == MAX) return result;
        int m = 0;
        while (m != -1) {
            result.add(m + 1);
            m = pre[m];
        }

        return result;
    }

}
