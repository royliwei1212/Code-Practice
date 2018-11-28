package tech.saltyegg.leetcode;

/**
 * Description: http://www.cnblogs.com/springfor/p/3884252.html
 *
 * @author hzhou
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9) return;
        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char v = '1'; v <= '9'; v++) {
                    if (!isValid(board, i, j, v)) continue;
                    board[i][j] = v;
                    if (helper(board)) return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == c || board[i][y] == c) return false;
        }

        int xStart = x / 3 * 3;
        int yStart = y / 3 * 3;
        for (int i = xStart; i < xStart + 3; i++) {
            for (int j = yStart; j < yStart + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }

        return true;
    }
}