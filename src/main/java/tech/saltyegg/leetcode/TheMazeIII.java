package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeIII {

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dir = new int[][]{{1, 0, 'd'}, {0, -1, 'l'}, {0, 1, 'r'}, {-1, 0, 'u'}};
        int[][] dp = new int[maze.length][maze[0].length];
        StringBuilder[][] result = new StringBuilder[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++)
                result[i][j] = new StringBuilder();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(ball[0], ball[1]));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int[] d : dir) {
                int x = p.x, y = p.y, c = 0;
                StringBuilder sb = new StringBuilder(result[p.x][p.y]);
                sb.append((char) d[2]);
                while (x + d[0] >= 0 && x + d[0] < maze.length && y + d[1] >= 0 && y + d[1] < maze[0].length
                        && maze[x + d[0]][y + d[1]] == 0) {
                    x += d[0];
                    y += d[1];
                    c++;
                    if (hole[0] == x && hole[1] == y) {
                        break;
                    }
                }
                if (dp[p.x][p.y] + c > 0 && (dp[x][y] == 0 || dp[p.x][p.y] + c < dp[x][y] || dp[p.x][p.y] + c == dp[x][y] &&
                        sb.toString().compareTo(result[x][y].toString()) < 0)) {
                    dp[x][y] = dp[p.x][p.y] + c;

                    result[x][y] = sb;

                    queue.add(new Point(x, y));
                }
            }
        }
        return dp[hole[0]][hole[1]] == 0 ? "impossible" : result[hole[0]][hole[1]].toString();
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
