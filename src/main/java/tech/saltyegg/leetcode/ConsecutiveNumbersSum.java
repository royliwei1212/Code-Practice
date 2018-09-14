package tech.saltyegg.leetcode;

public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int N) {
        int result = 0;
        for (int i = 1; i <= (int) Math.sqrt(2 * N); i++) {
            if ((2 * N % i) != 0) continue;
            int x = 2 * N / i - i - 1;
            if (x % 2 == 0 && x > 0) {
                result++;
            }
        }
        return result;
    }

}
