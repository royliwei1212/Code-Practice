package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/17/17
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        for (int i = 0; i <= s.length(); i++) {
            if (isPalindrome(s, i)) return true;
        }
        return false;
    }


    private boolean isPalindrome(String s, int ignoreIndex) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (l == ignoreIndex) l++;
            if (r == ignoreIndex) r--;

            if (l < r && s.charAt(l++) != s.charAt(r--)) return false;

        }
        return true;
    }

}
