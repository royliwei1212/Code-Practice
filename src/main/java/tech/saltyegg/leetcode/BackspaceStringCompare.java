package tech.saltyegg.leetcode;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        int l = S.length() - 1;
        int r = T.length() - 1;

        while (l >= 0 || r >= 0) {
            l = helper(S, l);
            r = helper(T, r);
            if (l < 0) return r < 0;
            if (r < 0) return l < 0;
            if (S.charAt(l) == T.charAt(r)) {
                l--;
                r--;
            } else {
                return false;
            }
        }
        return true;

    }

    private int helper(String s, int l) {
        int d = 0;
        while (l >= 0 && (s.charAt(l) == '#' || d > 0)) {
            if (s.charAt(l) == '#') d++;
            else d--;
            l--;
        }
        return l;
    }
}
