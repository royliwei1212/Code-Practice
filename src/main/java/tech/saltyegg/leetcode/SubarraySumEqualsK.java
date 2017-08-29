package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 8/28/17
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int result = 0;
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) {
                    result++;
                }
            }
        }
        return result;
    }

}
