/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

/**
 * Description: Given an array and a value, remove all instances of that value in place and return the new length.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @author hzhou
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i : nums) {
            if (i != val) {
                nums[index++] = i;
            }
        }
        return index;
    }
}