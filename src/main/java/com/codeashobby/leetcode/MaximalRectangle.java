package com.codeashobby.leetcode;

/**
 * Created by hzhou on 4/22/15. codeashobby@gmail.com
 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		int height = matrix.length;
		if (height == 0) {
			return 0;
		}
		int width = matrix[0].length;

		int ml = 0;
		int mt = 0;
		int mr = width - 1;
		int mb = height - 1;



	}

	private boolean checkLine(int line, char[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix[line].length; i++) {
			sum += matrix[line][i] - '0';
			if (sum > 0) {
				return true;
			}
		}
		return sum > 0;
	}

	private boolean checkRow(int row, char[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][row] - '0';
			if (sum > 0) {
				return true;
			}
		}
		return sum > 0;
	}
}
