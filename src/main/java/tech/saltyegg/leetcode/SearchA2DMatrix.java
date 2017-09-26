package tech.saltyegg.leetcode;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int h = matrix.length;
        int w = matrix[0].length;

        int l = 0, r = h * w - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int g = get(m, matrix);
            if (g == target) return true;
            if (g > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    private int get(int i, int[][] matrix) {
        int r = i / matrix[0].length;
        int c = i % matrix[0].length;
        return matrix[r][c];
    }
}