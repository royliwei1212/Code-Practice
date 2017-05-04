package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 2015/8/9.
 * Email: i@hzhou.me
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        result[len - 1] = 1;

        for (int i = len - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }

        int offSet = 1;
        for (int i = 0; i < len; i++) {
            result[i] *= offSet;
            offSet *= nums[i];
        }
        return result;
    }
}
