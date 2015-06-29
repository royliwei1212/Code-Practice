/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm
 * should run in linear time and in O(1) space.
 *
 * @author hzhou
 */
public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		if (nums.length < 3) {
			for (int i : nums) {
				if (!result.contains(i)) {
					result.add(i);
				}
			}
			return result;
		}

		int pivot = (int) Math.floor(nums.length / 3.0) + 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			int value = 1;
			if (map.containsKey(i)) {
				value += map.get(i);
				if (value == pivot) {
					result.add(i);
				}
			}
			map.put(i, value);
		}

		return result;
	}
}