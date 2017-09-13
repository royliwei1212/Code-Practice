package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/12/17
 */
public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;

        int length = A.length;
        int result = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            result += i * A[i];
            sum += A[i];
        }

        int preResult = result;
        for (int i = length - 1; i >= 0; i--) {
            int v = A[i];
            int r = preResult + sum - v * length;
            result = Math.max(result, r);
            preResult = r;
        }
        return result;

    }
}
