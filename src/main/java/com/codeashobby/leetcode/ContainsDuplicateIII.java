/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

/**
 * Description:
 *
 * @author hzhou
 */
public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2 || k < 1) {
			return false;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= i + k && j < nums.length; j++) {
				if (Math.abs(nums[i] - nums[j]) <= t) {
					return true;
				}
			}

		}
		return false;
	}
}