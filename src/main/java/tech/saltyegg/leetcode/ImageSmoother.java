package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 8/26/17
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) return new int[0][0];

        int[][] result = new int[M.length][M[0].length];
        for (int x = 0; x < M.length; x++) {
            for (int y = 0; y < M[0].length; y++) {
                result[x][y] = helper(x, y, M);
            }
        }
        return result;
    }

    private int helper(int x, int y, int[][] M) {
        int sum = 0;
        int count = 0;
        sum += M[x][y];
        count++;
        if (x > 0) {
            sum += M[x - 1][y];
            count++;
        }
        if (y > 0) {
            sum += M[x][y - 1];
            count++;
        }

        if (x > 0 && y > 0) {
            sum += M[x - 1][y - 1];
            count++;
        }

        if (x < M.length - 1) {
            sum += M[x + 1][y];
            count++;
        }

        if (y < M[x].length - 1) {
            sum += M[x][y + 1];
            count++;
        }

        if (x < M.length - 1 && y < M[x].length - 1) {
            sum += M[x + 1][y + 1];
            count++;
        }

        if (x > 0 && y < M[x].length - 1) {
            sum += M[x - 1][y + 1];
            count++;
        }

        if (y > 0 && x < M.length - 1) {
            sum += M[x + 1][y - 1];
            count++;
        }

        return sum / count;
    }

}
