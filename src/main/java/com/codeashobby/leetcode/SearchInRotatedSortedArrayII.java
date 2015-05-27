/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Description:
 *
 * @author hzhou
 */
public class SearchInRotatedSortedArrayII {

	public boolean search(int[] nums, int target) {
		return true;
	}

	private int getPivot(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (middle > 0 && nums[middle] < nums[middle - 1]) {
				return middle;
			}

			if (nums[start] == nums[middle]) {
				start++;
			} else if (nums[start] > nums[middle]) {
				end = middle;
			} else {
				start = middle;
			}
		}
		return 0;
	}

	@Test
	public void test() {
		int[] nums = new int[]{1, 1, 1, 1, 1, 1, 0};
		assertSame(6, getPivot(nums));
		nums = new int[]{1, 1, 1, 1, 1, 1, 1};
		assertSame(0, getPivot(nums));

		nums = new int[]{1, 2, 3, 1, 1, 1, 1};
		assertSame(3, getPivot(nums));
	}
}