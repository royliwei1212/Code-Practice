/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

/**
 * Description: Given an array with n objects colored red, white or blue, sort them so that objects of the same color
 * are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * @author hzhou
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int red = 0, blue = nums.length - 1;
        for (int i = red; i <= blue; i++) {
            if (nums[i] == 0) {
                swap(red++, i, nums);
            } else if (nums[i] == 2) {
                swap(blue--, i--, nums); // note i-- here
            }
        }
    }

    private void swap(int a, int b, int[] nums) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}