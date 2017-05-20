package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 5/20/17
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[] ordered = new int[nums.length];
        System.arraycopy(nums, 0, ordered, 0, nums.length);
        Arrays.sort(ordered);

        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            start = i;
            if (nums[i] != ordered[i]) {
                break;
            }
        }
        if (start == nums.length - 1) {
            return 0;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            end = i;
            if (nums[i] != ordered[i]) {
                break;
            }
        }

        return end - start + 1;
    }

}
