package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2015/8/16.
 * Email: i@hzhou.me
 */
public class PaintHouseRecursive {

    public int minCost(int[][] costs) {

        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[] min = new int[]{0};

        for (int i = 0; i < 3; i++) {
            helper(costs, i, 1, costs[0][i], min);
        }

        return min[0];
    }

    private void helper(int[][] costs, int lastColor, int start, int cost, int[] min) {
        if (start == costs.length) {
            min[0] = Math.min(min[0], cost);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i != lastColor) {
                helper(costs, i, start + 1, cost + costs[start][i], min);
            }
        }
    }
}
