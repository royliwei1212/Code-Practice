package tech.saltyegg.leetcode;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }

        int pre = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            pre += nums[i];
        }

        sum = pre;

        for (int i = k; i < nums.length; i++) {
            pre = pre - nums[i - k] + nums[i];
            sum = Math.max(sum, pre);
        }

        return 1.0 * sum / k;
    }

}
