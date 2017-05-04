package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2015/6/15.
 * Email: i@hzhou.me
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String r = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(r.substring(i))) {
                return r.substring(0, i) + s;
            }
        }

        return s;
    }
}
