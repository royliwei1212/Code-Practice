package tech.saltyegg.code;

import org.junit.Test;

public class LongestIncreasingSequence {

  public int findMax(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int max = 1;
    int[][] cache = new int[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        max = Math.max(dfs(grid, i, j, grid[i][j], cache), max);
      }
    }
    return max;
  }

  private int dfs(int[][] grid, int i, int j, int value, int[][] cache) {

    int[][] dir = {
      {0, 1},
      {0, -1},
      {1, 0},
      {-1, 0}
    };

    for (int[] p : dir) {
      int m = i + p[0];
      int n = j + p[1];
      if (m >= 0
          && n >= 0
          && m < grid.length
          && n < grid[0].length
          && grid[m][n] == grid[i][j] + 1) {
        cache[i][j] = Math.max(dfs(grid, m, n, value + 1, cache), cache[i][j]);
      }
    }
    cache[i][j]++;
    return cache[i][j];
  }

  @Test
  public void test() {
    int[][] grid =
        new int[][] {
          {1, 2, 8},
          {
            4, 9, 5,
          },
          {3, 7, 6}
        };

    int result = findMax(grid);
    System.out.println("result = " + result);
  }
}
