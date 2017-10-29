package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/17/17
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 3) return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isValid(s, l + 1, r) || isValid(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
