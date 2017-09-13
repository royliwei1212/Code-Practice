package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int[] offsetX = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
        int[] offsetY = new int[]{1, -1, 0, 1, -1, 1, 0, -1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + offsetX[k];
                    int y = j + offsetY[k];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        continue;
                    }

                    if (board[x][y] == 1 || board[x][y] == 2) {
                        count++;
                    }
                }

                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }

                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }

    }
}
