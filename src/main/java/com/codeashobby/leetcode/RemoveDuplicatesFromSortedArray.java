/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length < 2) {
			return nums.length;
		}
		int tmp = 1;
		for (int i = 1; i < nums.length; i++) {
			while (i < nums.length && nums[i] == nums[i - 1]) {
				i++;
			}
			if (i == nums.length) {
				break;
			}
			if (tmp != i) {
				nums[tmp] = nums[i];
			}
			tmp++;
		}

		return tmp;
	}

	@Test
	public void test() {
		int[] nums = new int[]{1, 2};
		int result = removeDuplicates(nums);
	}
}