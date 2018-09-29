package tech.saltyegg.leetcode;

/**
 * Created by zhouhao on 5/20/2015.
 * <p>
 * Given a string S, find the longest palindromic substring in S. You may assume that the
 * maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * <p>
 * Idea:
 * aba -> $a$b$a$
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];
        int l = 0;
        int r = 0;
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1]);
                if (dp[j][i] && max < i - j + 1) {
                    l = j;
                    r = i;
                    max = i - j + 1;
                }
            }

        }
        return s.substring(l, r + 1);
    }
}
