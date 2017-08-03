package tech.saltyegg.leetcode;

public class ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - nums[j] > nums[j]) {
                    result++;
                }
            }
        }
        return result;
    }

}
