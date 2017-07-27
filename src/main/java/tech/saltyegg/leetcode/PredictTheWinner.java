package tech.saltyegg.leetcode;

public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        return helper(0, nums.length - 1, nums) >= 0;
    }

    public int helper(int left, int right, int[] nums) {
        if (left == right) {
            return nums[left];
        }

        return Math.max(nums[left] - helper(left + 1, right, nums), nums[right] - helper(left, right - 1, nums));
    }
}
