/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.Arrays;

/**
 * Description:
 *
 * @author hzhou
 */
public class KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || k > nums.length) {
			return 0;
		}

		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}