package tech.saltyegg.code;

import java.util.Arrays;

import org.junit.Test;

public class PackageProblem {

    public int solution(int weight[], int value[], int maxWeight) {
        int[][] dp = new int[value.length + 1][maxWeight + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(weight, value, 0, maxWeight, dp);
    }

    private int helper(int weight[], int value[], int start, int leftWeight, int[][] dp) {
        if (dp[start][leftWeight] >= 0) {
            return dp[start][leftWeight];
        }

        int result = 0;
        if (start == value.length) {
            dp[start][leftWeight] = 0;
            return 0;
        }
        if (leftWeight < weight[start]) {
            result = helper(weight, value, start + 1, leftWeight, dp);
        } else {
            result = Math.max(helper(weight, value, start + 1, leftWeight, dp),
                    helper(weight, value, start + 1, leftWeight - weight[start], dp) + value[start]);
        }

        dp[start][leftWeight] = result;
        return result;
    }

    @Test
    public void test() {
        System.out.println(solution(new int[]{2, 1, 3, 2}, new int[]{3, 2, 4, 2}, 5));
    }
}
