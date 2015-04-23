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

		int ml = -1;
		int mt = -1;
		int mr = width;
		int mb = height;

		for (int i = 0; i < width; i++) {
			if (checkRow(i, matrix)) {
				ml = i;
				break;
			}
		}
		// if no 1 found
		if (ml == -1) {
			return 0;
		}

		for (int i = width - 1; i >= ml; i--) {
			if (checkRow(i, matrix)) {
				mr = i;
				break;
			}
		}

		for (int i = 0; i < height; i++) {
			if (checkLine(i, matrix)) {
				mt = i;
				break;
			}
		}

		for (int i = height - 1; i >= mt; i--) {
			if (checkLine(i, matrix)) {
				mb = i;
				break;
			}
		}

		return (mr - ml + 1) * (mb - mt + 1);

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
