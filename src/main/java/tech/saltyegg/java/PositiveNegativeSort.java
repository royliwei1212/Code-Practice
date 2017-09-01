package tech.saltyegg.java;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 8/31/17
 */
public class PositiveNegativeSort {

    public static void sort(int[] x) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] < 0) {
                continue;
            }

            int crt = x[i];

            int j = i + 1;
            while (j < x.length && x[j] >= 0) {
                j++;
            }
            if (j == x.length) return;

            x[i] = x[j];
            helper(x, i, j);
            x[i + 1] = crt;
        }
    }

    private static void helper(int[] x, int start, int end) {
        System.arraycopy(x, start, x, start + 1, end - start);
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 5, -3, 9, 0, -10, -4};
        sort(x);
        Arrays.stream(x).forEach(System.out::println);
    }
}
