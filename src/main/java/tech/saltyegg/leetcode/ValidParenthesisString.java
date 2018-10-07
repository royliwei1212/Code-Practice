package tech.saltyegg.leetcode;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) return true;

        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ')') b++;
            else b--;

            if (b < 0) return false;
        }
        if (b == 0) return true;
        b = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '(') b++;
            else b--;

            if (b < 0) return false;
        }

        return true;
    }
}
