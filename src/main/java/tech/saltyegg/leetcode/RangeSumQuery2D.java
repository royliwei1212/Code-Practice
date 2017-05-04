package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/6/1.
 * Email: i@hzhou.me
 */
public class RangeSumQuery2D {

    private int[][] dict;

    public RangeSumQuery2D(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        dict = new int[matrix.length][matrix[0].length];
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int x = matrix[0][i];
            sum += x;
            dict[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int x = matrix[i][0];
            sum += x;
            dict[i][0] = sum;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dict[i][j] = dict[i - 1][j] + dict[i][j - 1] - dict[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dict[row2][col2] -
                (col1 == 0 ? 0 : dict[row2][col1 - 1]) -
                (row1 == 0 ? 0 : dict[row1 - 1][col2]) +
                (col1 * row1 == 0 ? 0 : dict[row1 - 1][col1 - 1]);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        RangeSumQuery2D rs = new RangeSumQuery2D(matrix);
        System.out.println(rs.sumRegion(2, 1, 4, 3));
        System.out.println(rs.sumRegion(1, 1, 2, 2));
        System.out.println(rs.sumRegion(1, 2, 2, 4));
    }

}
