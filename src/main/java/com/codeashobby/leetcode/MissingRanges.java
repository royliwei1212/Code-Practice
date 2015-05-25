/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Description: Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its
 * missing ranges.
 * <p/>
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 *
 * @author hzhou
 */
public class MissingRanges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			if (lower == upper) {
				result.add(String.valueOf(lower));
			}
			if (lower < upper) {
				result.add(lower + "->" + upper);
			}
			return result;
		}
		int start, end;
		end = 1;
		if (lower < nums[0]) {
			if (lower + 1 == nums[0]) {
				result.add(String.valueOf(lower));
			} else {
				result.add(lower + "->" + Math.min(upper, nums[0] - 1));
			}
			while (end < nums.length && nums[end - 1] + 1 == nums[end]) {
				end++;
			}
			if (end < nums.length) {
				end--;
			}
		} else {
			while (end < nums.length && nums[end] < lower) {
				end++;
			}
		}
		start = end < nums.length ? nums[end] + 1 : 0;
		end++;
		while (end < nums.length) {

			String s = start == nums[end] - 1 ? String.valueOf(start) : start + "->" + Math.min(upper, nums[end] - 1);
			result.add(s);
			while (end < nums.length - 1 && nums[end] + 1 == nums[end + 1]) {
				end++;
			}
			if (end < nums.length) {
				start = nums[end] + 1;
				end++;
			}
		}

		int num = nums[nums.length - 1];
		if (num < upper) {
			if (num + 1 == upper) {
				result.add(String.valueOf(upper));
			} else {
				result.add(Math.max(lower, num + 1) + "->" + upper);
			}
		}

		return result;
	}

	@Test
	public void test() {
		int[] nums = new int[]{0, 1, 3, 50, 75};
		List<String> result = findMissingRanges(nums, 0, 99);
		for (String s : result) {
			System.out.println(s);
		}
	}
}