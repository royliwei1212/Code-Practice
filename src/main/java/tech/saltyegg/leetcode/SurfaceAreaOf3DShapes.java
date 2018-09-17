package tech.saltyegg.leetcode;

public class SurfaceAreaOf3DShapes {

    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int N = grid.length;
        int result = 2 * N * N;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int a = grid[i][j];
                int b = j == N - 1 ? 0 : grid[i][j + 1];
                int c = i == N - 1 ? 0 : grid[i + 1][j];
                result += 4 * a;
                if (a == 0) result -= 2;
                result -= 2 * Math.min(a, b);
                result -= 2 * Math.min(a, c);
            }
        }
        return result;
    }
}
