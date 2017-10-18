/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

/**
 * Description: Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * @author hzhou
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; ) {
            int crt = nums[i];
            if (crt > 0 && crt <= nums.length && i + 1 != crt && nums[i] != nums[crt - 1]) {
                nums[i] = nums[crt - 1];
                nums[crt - 1] = crt;
            } else {
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}