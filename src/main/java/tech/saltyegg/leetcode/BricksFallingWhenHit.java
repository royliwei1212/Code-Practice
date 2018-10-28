package tech.saltyegg.leetcode;

public class BricksFallingWhenHit {

    private int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int r, c;

    public int[] hitBricks(int[][] grid, int[][] hits) {

        if (grid == null || grid.length == 0 || hits == null || hits.length == 0) return new int[0];

        r = grid.length;
        c = grid[0].length;
        int[] result = new int[hits.length];

        for (int[] h : hits) {
            if (grid[h[0]][h[1]] == 1) grid[h[0]][h[1]] = -1;
        }

        countBricks(grid);

        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] != 0) {
                grid[x][y] = 1;
                if (attachedToTop(grid, x, y)) {
                    result[i] = dfs(grid, x, y) - 1;
                }
            }
        }

        return result;
    }

    private int countBricks(int[][] grid) {
        int count = 0;
        for (int i = 0; i < c; i++) {
            count += dfs(grid, 0, i);
        }
        return count;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (grid[x][y] != 1) return 0;
        grid[x][y] = 2;
        int count = 1;
        for (int[] d : dir) {
            int m = x + d[0];
            int n = y + d[1];

            if (m < 0 || n < 0 || m >= r || n >= c || grid[m][n] != 1) continue;
            count += dfs(grid, m, n);
        }
        return count;
    }

    private boolean attachedToTop(int[][] grid, int x, int y) {
        if (x == 0) return true;
        for (int[] d : dir) {
            int m = x + d[0];
            int n = y + d[1];
            if (m < 0 || n < 0 || m >= r || n >= c) continue;
            if (grid[m][n] == 2) return true;
        }
        return false;
    }
}
