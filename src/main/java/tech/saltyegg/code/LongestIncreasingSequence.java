package tech.saltyegg.code;

import org.junit.Test;

public class LongestIncreasingSequence {

    // private Map<Integer, Integer> cache = new HashMap<>();

    int max = 1;

    public int findMax(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j, grid[i][j], 0);
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j, int value, int count) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != value) {
            max = Math.max(max, count);
            return;
        }

        count++;

        int[][] dir = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        for (int[] p : dir) {
            int m = i + p[0];
            int n = j + p[1];
            dfs(grid, m, n, value + 1, count);
        }

    }


    @Test
    public void test() {
        int[][] grid = new int[][]{
                {1, 2, 8}, {4, 9, 5,}, {3, 7, 6}
        };

        int result = findMax(grid);
        System.out.println("result = " + result);
    }
}
