package tech.saltyegg.leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String t, String s) {
        if (s == null || s.isEmpty()) return t == null || t.isEmpty();
        if (t == null || t.isEmpty()) return true;

        int l = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = s.indexOf(c, l);
            if (index == -1) return false;
            l = index + 1;
        }
        return true;
    }
}