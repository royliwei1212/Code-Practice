package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class UniqueSubstringsInWraparoundString {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];

        int len = 1;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                len++;
            } else {
                len = 1;
            }

            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], len);
        }
        return Arrays.stream(dp).sum();
    }

}
