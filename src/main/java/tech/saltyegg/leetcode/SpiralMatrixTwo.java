/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import org.junit.Test;

/**
 * Description
 *
 * @author hzhou
 */
public class SpiralMatrixTwo {

    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int val = 1;

        int x = 0;
        int y = 0;
        int w = n;
        while (w > 0) {
            // top
            for (int i = 0; i < w - 1; i++) {
                matrix[x][y++] = val++;
            }

            // right
            for (int i = 0; i < w - 1; i++) {
                matrix[x++][y] = val++;
            }

            // button
            for (int i = 0; i < w - 1; i++) {
                matrix[x][y--] = val++;
            }

            // right
            for (int i = 0; i < w - 1; i++) {
                matrix[x--][y] = val++;
            }

            w = w - 2;
            x++;
            y++;
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = val;
        }
        return matrix;
    }

    @Test
    public void test() {
        generateMatrix(1);
    }
}