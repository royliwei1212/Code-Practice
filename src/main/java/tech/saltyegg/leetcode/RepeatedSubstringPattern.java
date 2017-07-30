package tech.saltyegg.leetcode;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            String sub = s.substring(0, i);
            if ((s.substring(i, s.length()) + sub).equals(s)) return true;
        }
        return false;
    }

}
