package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[j - 1]) {
                    result = Math.max(result, j - i);
                    i = j - 1;
                    break;
                }

                if (j == nums.length - 1) result = Math.max(result, j - i + 1);
            }
        }
        return result;
    }

}
