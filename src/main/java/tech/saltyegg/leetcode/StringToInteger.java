package tech.saltyegg.leetcode;

/**
 * Description
 *
 * @author hzhou
 */
public class StringToInteger {

    public int myAtoi(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        str = str.trim();
        long result = 0;
        int isNegative = 1;
        int start = 0;
        if (str.charAt(0) == '+') {
            start++;
        } else if (str.charAt(0) == '-') {
            isNegative = -1;
            start++;
        }
        if (str.length() == start) {
            return 0;
        }

        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') return (int) (isNegative * result);
            result = 10 * result + (c - '0');
            if (isNegative * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNegative * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (isNegative * result);
    }

}