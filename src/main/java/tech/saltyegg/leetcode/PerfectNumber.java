package tech.saltyegg.leetcode;

public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num < 2) return false;
        int sqrt = (int) Math.sqrt(num);
        int result = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                result += i + (num / i);
            }
        }
        if (sqrt * sqrt == num) {
            result -= sqrt;
        }

        return result == num;
    }

}
