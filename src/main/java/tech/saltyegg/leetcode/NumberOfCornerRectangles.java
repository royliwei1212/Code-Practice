package tech.saltyegg.leetcode;

import org.junit.Test;

public class NumberOfCornerRectangles {

    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length < 2 || grid[0] == null || grid[0].length < 2) return 0;
        int result = 0;

        for (int i = 0; i < grid.length - 1; i++) {
            for (int k = i + 1; k < grid.length; k++) {
                int count = 0;
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[k][j] == 1 && grid[i][j] == 1) count++;
                }
                result += (count - 1) * count / 2;
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{{0, 1, 0}, {1, 0, 1}, {1, 0, 1}, {0, 1, 0}};
        System.out.println(countCornerRectangles(grid));
    }
}
