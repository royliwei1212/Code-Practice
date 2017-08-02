package tech.saltyegg.leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i, j;
        i = j = 0;
        while (i < t.length() && j < s.length()) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
            i++;
        }
        return j == s.length();
    }
}