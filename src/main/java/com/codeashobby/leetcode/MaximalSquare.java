package com.codeashobby.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by hzhou on 2015/6/7.
 * Email: i@hzhou.me
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int h = matrix.length;
        int w = matrix[0].length;
        int[][] map = new int[h][w + 1];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0) {
                    map[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = 1 + map[i - 1][j];
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < h; i++) {
            max = Math.max(max, helper(map[i]));
        }

        return max;
    }

    private int helper(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int crt, max;
        crt = max = 0;
        while (crt < height.length) {
            if (stack.isEmpty() || height[crt] >= height[stack.peek()]) {
                stack.push(crt++);
            } else {
                int top = stack.pop();
                int length = Math.min(height[top], (stack.isEmpty() ? crt : crt - stack.peek() - 1));
                max = Math.max(max, length * length);
            }
        }

        return max;
    }

    @Test
    public void test() {
        char[][] map = new char[1][1];
        map[0][0] = '0';
        maximalSquare(map);
    }
}
