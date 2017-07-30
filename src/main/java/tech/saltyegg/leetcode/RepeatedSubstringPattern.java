package tech.saltyegg.leetcode;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= s.length() / 2; i++) {
            sb.setLength(0);
            String sub = s.substring(0, i);
            if (sb.append(s.substring(i, s.length())).append(sub).toString().equals(s)) return true;
        }

        return false;
    }

}
