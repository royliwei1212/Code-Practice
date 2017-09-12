package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/11/17
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                int val = sum[i] - sum[j];
                if ((k == 0 && val == 0) || (k != 0 && val % k == 0)) return true;
            }
        }
        return false;
    }

}
