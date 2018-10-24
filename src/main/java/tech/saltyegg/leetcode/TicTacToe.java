package tech.saltyegg.leetcode;

public class TicTacToe {

    private int[][] d;

    public TicTacToe(int n) {
        d = new int[n][n];
    }

    public int move(int row, int col, int player) {
        d[row][col] = player;
        return win(row, col, player) ? player : 0;
    }

    private boolean win(int row, int col, int player) {
        for (int i = 0; i < d.length; i++) {
            if (d[i][col] != player) break;
            if (i == d.length - 1) return true;
        }

        for (int i = 0; i < d.length; i++) {
            if (d[row][i] != player) break;
            if (i == d.length - 1) return true;
        }

        if (col == row) {
            for (int i = 0; i < d.length; i++) {
                if (d[i][i] != player) break;
                if (i == d.length - 1) return true;
            }
        }

        if (col + row == d.length - 1) {
            for (int i = 0; i < d.length; i++) {
                if (d[d.length - 1 - i][i] != player) break;
                if (i == d.length - 1) return true;
            }
        }

        return false;
    }
}
