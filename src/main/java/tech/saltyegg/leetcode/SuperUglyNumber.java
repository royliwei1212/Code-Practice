package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/9.
 * Email: i@hzhou.me
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 1 || primes == null || primes.length == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int size = primes.length;
        int[] pos = new int[size];

        int[] dict = new int[n];
        dict[0] = 1;
        for (int i = 1; i < n; i++) {
            int[] result = getBatchResult(pos, primes, dict);
            int minPos = findMinIndex(result);
            pos[minPos]++;
            if (i > 0 && result[minPos] == dict[i - 1]) {
                i--;
                continue;
            }
            dict[i] = result[minPos];
        }

        return dict[n - 1];
    }

    private int[] getBatchResult(int[] pos, int[] primes, int[] dict) {
        int[] result = new int[primes.length];
        for (int i = 0; i < primes.length; i++) {
            result[i] = primes[i] * dict[pos[i]];
        }
        return result;
    }

    private int findMinIndex(int[] arr) {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        SuperUglyNumber sun = new SuperUglyNumber();
        System.out.println(sun.nthSuperUglyNumber(10, new int[]{3,5,7,13,17,19,29,31,37,41,47,59,71,73,79,83,97,127,131,137}));
    }
}
