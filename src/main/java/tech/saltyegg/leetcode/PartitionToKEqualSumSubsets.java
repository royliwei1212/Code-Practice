package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * http://www.voidcn.com/article/p-pyoxzvmf-bpb.html
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return false;
        Arrays.sort(nums);
        reverse(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        if (nums[0] > target) return false;

        int[] container = new int[k];
        boolean[] result = new boolean[]{false};
        helper(0, nums, k, target, container, result);
        return result[0];
    }

    private void helper(int start, int[] nums, int k, int target, int[] container, boolean[] result) {
        if (result[0]) return;
        if (start == nums.length) {
            int i = 0;
            for (; i < container.length; i++) {
                if (container[i] != target) break;
            }
            if (i == container.length) result[0] = true;
            return;
        }

        for (int i = 0; i < container.length; i++) {
            if (container[i] + nums[start] <= target) {
                container[i] += nums[start];
                helper(start + 1, nums, k, target, container, result);
                container[i] -= nums[start];
            }
        }
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
