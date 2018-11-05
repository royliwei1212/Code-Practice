package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        // null check ignored
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            board[click[0]][click[1]] = 'B';
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int count = 0;
            for (int[] d : dir) {
                int x = node[0] + d[0];
                int y = node[1] + d[1];
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
                if (board[x][y] == 'M') count++;
            }
            if (count != 0) {
                board[node[0]][node[1]] = (char) (count + '0');
            } else {
                for (int[] d : dir) {
                    int x = node[0] + d[0];
                    int y = node[1] + d[1];
                    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
                    if (board[x][y] == 'E') {
                        board[x][y] = 'B';
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return board;
    }
}
