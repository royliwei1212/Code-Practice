package tech.saltyegg.leetcode;

/**
 * Description:
 *
 * @author hzhou
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        int n = matrix.length;
        int m = n;
        if (n % 2 != 0) {
            m++;
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1 - j];
                matrix[n - i - 1][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        if (matrix == null) return;

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                swap(matrix, i, l, i, r);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                swap(matrix, i, j, n - j - 1, n - i - 1);
            }
        }
    }

    private void swap(int[][] matrix, int a, int b, int x, int y) {
        int t = matrix[a][b];
        matrix[a][b] = matrix[x][y];
        matrix[x][y] = t;
    }
}