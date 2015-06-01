package com.codeashobby.leetcode;

import java.util.Stack;

/**
 * Created by hzhou on 4/22/15. codeashobby@gmail.com
 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int[][] map = new int[matrix.length][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					map[i][j] = 0;
				} else {
					map[i][j] = i == 0 ? 1 : map[i - 1][j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			int value = helper(map[i]);
			max = Math.max(max, value);
		}

		return max;
	}

	public int helper(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();

		int crt = 0;
		int max = 0;
		while (crt < height.length) {
			if (stack.isEmpty() || height[crt] >= height[stack.peek()]) {
				stack.push(crt++);
			} else {
				int i = stack.pop();
				max = Math.max(max, height[i] * (stack.isEmpty() ? crt : crt - stack.peek() - 1));
			}
		}

		return max;
	}
}
