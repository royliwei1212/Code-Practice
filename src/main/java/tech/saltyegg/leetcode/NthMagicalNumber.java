package tech.saltyegg.leetcode;

public class NthMagicalNumber {

    public int nthMagicalNumber(int N, int A, int B) {

        int lcm = A * B / gbc(A, B);
        long left = 0;
        long right = Long.MAX_VALUE;
        long modulo = (long) Math.pow(10, 9) + 7;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = mid / A + mid / B - mid / lcm;

            if (count >= N) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) (left % modulo);
    }

    private int gbc(int a, int b) {
        return (b == 0) ? a : gbc(b, a % b);
    }
}
