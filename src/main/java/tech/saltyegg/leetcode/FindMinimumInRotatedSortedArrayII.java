/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import org.junit.Test;

/**
 * Description
 *
 * @author hzhou
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        return helper(0, nums.length - 1, nums);
    }

    private int helper(int start, int end, int[] nums) {
        if (end - start <= 1) {
            return Math.min(nums[end], nums[start]);
        }

        if (nums[start] < nums[end]) {
            return nums[start];
        }
        int middle = (start + end) / 2;

        if (nums[start] == nums[end]) {
            return helper(start + 1, end, nums);
        }

        return nums[middle] >= nums[start] ? helper(middle, end, nums) : helper(start, middle, nums);

    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 1};
        System.out.println(findMin(nums));
    }
}