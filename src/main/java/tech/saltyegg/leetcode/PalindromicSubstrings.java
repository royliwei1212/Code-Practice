package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += helper(s, i, i);
            result += helper(s, i, i + 1);
        }
        return result;
    }

    private int helper(String s, int l, int r) {
        int count = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
