package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/17/17
 */
public class CountOfRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int result = 0;
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < i; j++) {
                long x = sum[i] - sum[j];
                if (lower <= x && x <= upper) result++;
            }
        }
        return result;
    }

}
