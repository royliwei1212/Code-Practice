package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/28.
 * Email: i@hzhou.me
 */
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0 || A[0].length != B.length) {
            return new int[0][0];
        }

        int[][] result = new int[A.length][B[0].length];
        int length = B[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) continue;
                for (int k = 0; k < length; k++) {
                    result[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return result;
    }
}
