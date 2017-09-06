package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/5/17
 */
public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3) return true;

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] < 0) {
                count--;
                if (i > 1 && nums[i] <= nums[i - 2]) nums[i] = nums[i - 1];
            }
            if (count < 0) return false;
        }
        return true;
    }
}
