package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * http://www.voidcn.com/article/p-pyoxzvmf-bpb.html
 */
public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;

        return helper(nums, k, new boolean[nums.length], 0, sum / k, 0);
    }

    private boolean helper(int[] nums, int k, boolean[] visited, int start, int target, int sum) {
        if (k == 1) return true;
        if (sum > target) return false;
        if (sum == target) return helper(nums, k - 1, visited, 0, target, 0);
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(nums, k, visited, i + 1, target, sum + nums[i])) return true;
            visited[i] = false;
        }
        return false;
    }
}
