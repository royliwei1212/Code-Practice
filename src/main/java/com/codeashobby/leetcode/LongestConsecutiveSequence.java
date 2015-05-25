/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Description: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p/>
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its
 * length: 4.
 * <p/>
 * Your algorithm should run in O(n) complexity.
 *
 * @author hzhou
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}

		int min = nums[0];
		int max = nums[0];
		Set<Integer> set = new HashSet<Integer>();
		set.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			set.add(nums[i]);
			if (max < nums[i]) {
				max = nums[i];
			}

			if (min > nums[i]) {
				min = nums[i];
			}
		}

		int result = 0;
		int crt = 1;
		for (int i = min + 1; i <= max; i++) {
			if (set.contains(i)) {
				crt++;
			} else {
				if (result < crt) {
					result = crt;
				}
				crt = 0;
			}
		}
		return result;
	}

	@Test
	public void test() {
		int[] nums = new int[]{100, 4, 200, 1, 3, 2, 5};
		assertSame(5, longestConsecutive(nums));
	}
}