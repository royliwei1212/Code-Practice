package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 5/20/17
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int islandCount = 0;
        int connection = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int crt = grid[i][j];
                if (crt == 1) {
                    islandCount++;


                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        connection++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        connection++;
                    }
                }
            }
        }
        return 4 * islandCount - 2 * connection;
    }
}
