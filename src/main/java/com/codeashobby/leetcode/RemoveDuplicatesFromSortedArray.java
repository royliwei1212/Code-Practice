/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

/**
 * Description:
 *
 * @author hzhou
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        int pre = nums[0];
        for (int i : nums) {
            if (i != pre) {
                nums[index++] = i;
                pre = i;
            }
        }
        return index;
    }
}