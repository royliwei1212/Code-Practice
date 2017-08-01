package tech.saltyegg.leetcode;

public class LargestPalindromeProduct {

    public int largestPalindrome(int n) {
        if (n == 1) return 9;

        int max = (int) Math.pow(10, n) - 1;
        int min = (int) Math.pow(10, n - 1);
        for (int i = max; i >= min; i--) {
            long p = getPalindrome(i);
            for (int j = max; j >= min; j--) {
                if (p / j > max || p / j < min) break;
                if (p % j == 0) {
                    return (int) (p % 1337);
                }
            }
        }
        return -1;
    }

    private long getPalindrome(int x) {
        String value = x + new StringBuilder(x + "").reverse().toString();
        return Long.valueOf(value);
    }
}
