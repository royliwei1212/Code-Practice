package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hzhou
 * @since 4/25/17
 */
public class ZeroOneMatrix {

    private static final List<Point> DIRECTIONS = new ArrayList<>();

    static {
        DIRECTIONS.add(new Point(0, 1));
        DIRECTIONS.add(new Point(1, 0));
        DIRECTIONS.add(new Point(0, -1));
        DIRECTIONS.add(new Point(-1, 0));
    }


    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int h = matrix.length;
        int w = matrix[0].length;

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Point(i, j));
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (Point dir : DIRECTIONS) {
                int x = p.getX() + dir.getX();
                int y = p.getY() + dir.getY();
                if (x < 0 || y < 0 || x >= h || y >= w) {
                    continue;
                }
                if (matrix[p.getX()][p.getY()] >= matrix[x][y]) {
                    continue;
                }

                matrix[x][y] = matrix[p.getX()][p.getY()] + 1;
                queue.offer(new Point(x, y));
            }
        }
        return matrix;
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
