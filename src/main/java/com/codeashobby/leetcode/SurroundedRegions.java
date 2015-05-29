/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

/**
 * Description:
 *
 * @author hzhou
 */
public class SurroundedRegions {

	public void solve(char[][] board) {
		if (board == null || board.length < 3 || board[0] == null || board[0].length < 3) {
			return;
		}

		for (int i = 0; i < board.length; i++) {
			helper(board, i, 0);
		}

		for (int i = 0; i < board[0].length; i++) {
			helper(board, 0, i);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if(board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void helper(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return;
		}

		char c = board[i][j];
		if (c == 'O') {
			board[i][j] = '#';
			helper(board, i + 1, j);
			helper(board, i - 1, j);
			helper(board, i, j + 1);
			helper(board, i, j - 1);
		}
	}
}