package tech.saltyegg.leetcode;

/**
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
 * <p>
 * Created by hzhou on 2016/5/4.
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 4) {
            return n;
        }

        int[] map = new int[n];
        map[0] = 1;
        int l1, l2, l3;
        l1 = l2 = l3 = 0;

        for (int i = 1; i < n; i++) {
            int a = map[l1] * 2;
            int b = map[l2] * 3;
            int c = map[l3] * 5;

            int m = min(a, b, c);
            if (m == a) l1++;
            if (m == b) l2++;
            if (m == c) l3++;
            map[i] = m;
        }


        return map[n - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
