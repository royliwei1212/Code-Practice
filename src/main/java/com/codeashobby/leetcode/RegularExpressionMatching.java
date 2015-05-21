package com.codeashobby.leetcode;

/**
 * Created by zhouhao on 5/19/2015.
 * <p>
 * Implement regular expression matching with support for '.' and '*'.
 * <pre>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * </pre>
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || s.isEmpty()) {
            return emptyable(p);
        }

        if (p == null || p.isEmpty()) {
            return false;
        }

        char cs = s.charAt(0);
        char cp = p.charAt(0);
        char tmp = p.length() > 1 ? p.charAt(1) : '\0';

        if (tmp == '*') {
            if (equalChar(cs, cp)) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            return equalChar(cs, cp) && isMatch(s.substring(1), p.substring(1));
        }
    }

    private boolean equalChar(char a, char b) {
        return b == '.' || a == b;
    }

    private boolean emptyable(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        for (int i = 1; i < s.length(); i = i + 2) {
            if (s.charAt(i) != '*') return false;
        }

        return true;
    }
}
