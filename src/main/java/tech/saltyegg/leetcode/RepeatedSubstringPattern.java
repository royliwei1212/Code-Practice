package tech.saltyegg.leetcode;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length() / 2; i++) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0).append(c);
            if (sb.toString().equals(s)) return true;
        }

        return false;
    }

}
