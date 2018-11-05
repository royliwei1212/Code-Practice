package tech.saltyegg.leetcode;

public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0) return new int[0][0];
        int r = board.length, c = board[0].length;
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) continue;
                    if (i < r - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                        int k = i;
                        while (k < r && Math.abs(board[k][j]) == val) board[k++][j] = -val;
                        found = true;
                    }

                    if (j < c - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                        int k = j;
                        while (k < c && Math.abs(board[i][k]) == val) board[i][k++] = -val;
                        found = true;
                    }
                }
            }
            // remove negative data
            if (found) {
                for (int i = 0; i < c; i++) {
                    int k = r - 1;
                    for (int j = k; j >= 0; j--) {
                        if (board[j][i] > 0) board[k--][i] = board[j][i];
                    }
                    while (k >= 0) board[k--][i] = 0;
                }
            }
        }
        return board;
    }
}
