package tech.saltyegg.leetcode;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int result = 0, pre = 0, crt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                crt++;
            } else {
                pre = crt;
                crt = 1;
            }
            if (pre >= crt) result++;
        }
        return result;
    }

}
