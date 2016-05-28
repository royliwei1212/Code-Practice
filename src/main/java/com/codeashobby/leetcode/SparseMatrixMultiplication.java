package com.codeashobby.leetcode;

/**
 * Created by hzhou on 2016/5/28.
 * Email: i@hzhou.me
 */
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0 || A[0].length != B.length) {
            return new int[0][0];
        }

        int[][] result = new int[A.length][B.length];
        int length = B[0].length;
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < A.length; k++) {
                result[k][i] = getSum(A, k, B, i);
            }
        }
        return result;
    }

    private int getSum(int[][] A, int a, int[][] B, int b) {
        int sum = 0;

        for (int i = 0; i < A[0].length; i++) {
            int x = A[a][i];
            int y = B[i][b];
            sum += x * y;
        }

        return sum;
    }


}
