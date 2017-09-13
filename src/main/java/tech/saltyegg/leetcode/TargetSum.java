package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int sum = Arrays.stream(nums).sum();
        if (S > Math.abs(sum) || (sum - S) % 2 != 0) {
            return 0;
        }

        int target = (sum - S) / 2;
        boolean[] visited = new boolean[nums.length];
        int[] result = new int[]{0};

        helper(0, nums, target, result, visited);
        return result[0];
    }

    private void helper(int start, int[] nums, int target, int[] result, boolean[] visited) {
        if (target == 0) {
            result[0]++;
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            helper(i + 1, nums, target - nums[i], result, visited);
            visited[i] = false;
        }
    }

}
