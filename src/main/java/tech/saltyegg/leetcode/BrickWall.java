package tech.saltyegg.leetcode;

import java.util.List;

/**
 * @author hzhou
 * @since 9/2/17
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int sum = wall.get(0).stream().mapToInt(Integer::intValue).sum();

        int[][] dict = new int[wall.size()][sum];
        for (int i = 0; i < dict.length; i++) {
            for (int j = 0; j < sum; j++) {
                dict[i][j] = 1;
            }
        }

        for (int i = 0; i < wall.size(); i++) {
            List<Integer> list = wall.get(i);
            int s = 0;
            for (int x : list) {
                s += x;
                if (s < sum) dict[i][s] = 0;
            }
        }

        int result = wall.size();
        for (int i = 1; i < sum; i++) {
            int x = 0;
            for (int j = 0; j < wall.size(); j++) {
                x += dict[j][i];
            }
            result = Math.min(x, result);
        }

        return result;
    }

}
