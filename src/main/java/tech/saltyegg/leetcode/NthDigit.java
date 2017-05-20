package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 5/20/17
 */
public class NthDigit {

    public int findNthDigit(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String x = String.valueOf(i);
            int len = x.length();
            if (count + len < n) {
                count += len;
            } else {
                return x.charAt(n - count - 1) - '0';
            }
        }

        return 0;
    }
}
