package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 5/1/17
 */
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int h = nums.length;
        int w = nums[0].length;

        if (h * w != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        int x = 0;
        int y = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (y + 1 >= c) x++;
                y = (y + 1) % c;

                result[x][y] = nums[i][j];
            }
        }
        return result;

    }

}
