package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/2/17
 */
public class BeautifulArrangementII {

    public int[] constructArray(int n, int k) {
        if (n < 1 || k <= n) return new int[0];

        int[] result = new int[n];

        for (int i = n; i > k + 1; i--) {
            result[i - 1] = i;
        }

        int a = 1;
        int b = k + 1;
        for (int i = 0; i <= k; i += 2) {
            result[i] = a++;
            if (i < k) result[i + 1] = b--;
        }

        return result;
    }
}
