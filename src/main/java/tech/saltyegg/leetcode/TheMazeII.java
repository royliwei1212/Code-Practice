package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dp = new int[maze.length][maze[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int[] d : dir) {
                int x = p.x, y = p.y, c = 0;
                while (x + d[0] >= 0 && x + d[0] < maze.length && y + d[1] >= 0 && y + d[1] < maze[0].length
                        && maze[x + d[0]][y + d[1]] == 0) {
                    x += d[0];
                    y += d[1];
                    c++;
                }
                if (!visited[x][y] || dp[p.x][p.y] + c < dp[x][y]) {
                    visited[x][y] = true;
                    dp[x][y] = dp[p.x][p.y] + c;
                    queue.add(new Point(x, y));
                }
            }
        }
        return dp[destination[0]][destination[1]] == 0 ? -1 : dp[destination[0]][destination[1]];
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
