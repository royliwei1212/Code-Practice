package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int px = p.x, py = p.y;
            for (int[] d : dir) {
                int x = px, y = py;
                while (x + d[0] >= 0 && x + d[0] < maze.length && y + d[1] >= 0 && y + d[1] < maze[0].length && maze[x + d[0]][y + d[1]] == 0) {
                    x += d[0];
                    y += d[1];
                }
                if (x == destination[0] && y == destination[1]) return true;
                if (visited[x][y]) continue;
                visited[x][y] = true;
                queue.add(new Point(x, y));
            }
        }
        return false;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
