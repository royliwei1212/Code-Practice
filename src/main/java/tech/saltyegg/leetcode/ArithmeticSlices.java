package tech.saltyegg.leetcode;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int result = 0;
        int len = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                len++;
            } else {
                if (len > 2) {
                    result += (len - 1) * (len - 2) / 2;
                }
                len = 2;
            }
        }
        if (len > 2) {
            result += (len - 1) * (len - 2) / 2;
        }
        return result;
    }

}
