package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 7/11/17
 */
public class MinimumFactorization {

    public int smallestFactorization(int a) {
        if (a == 1) {
            return 1;
        }
        int[] map = new int[10];

        while (a > 1) {
            for (int i = 2; i <= a; i++) {
                if (i > 9) {
                    return 0;
                }
                if (a % i == 0) {
                    map[i]++;
                    a /= i;
                    break;
                }
            }
        }

        map[9] += map[3] / 2;
        map[3] %= 2;

        map[8] += map[2] / 3;
        map[2] %= 3;

        int min = Math.min(map[2], map[3]);
        map[6] += min;
        map[2] -= min;
        map[3] -= min;

        map[4] += map[2] / 2;
        map[2] %= 2;

        long result = 0L;

        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j < map[i]; j++) {
                result = result * 10 + i;
            }
        }

        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;

    }
}
