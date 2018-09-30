package tech.saltyegg.leetcode;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void helper(int[][] image, int x, int y, int v, int n) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != v || image[x][y] == n) return;

        image[x][y] = n;
        helper(image, x + 1, y, v, n);
        helper(image, x - 1, y, v, n);
        helper(image, x, y + 1, v, n);
        helper(image, x, y - 1, v, n);
    }
}
