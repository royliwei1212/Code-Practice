package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2016/5/18.
 */
public class RangeSumQueryImmutable {

    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        if (nums != null && nums.length > 0) {
            sum = new int[nums.length];
            int x = 0;
            for (int i = 0; i < nums.length; i++) {
                x += nums[i];
                sum[i] = x;
            }
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null || i > j || j >= sum.length) {
            return 0;
        }

        return sum[j] - (i > 0 ? sum[i - 1] : 0);
    }

}
