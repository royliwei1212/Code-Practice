/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Description: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm
 * should run in linear time and in O(1) space.
 *
 * @author hzhou
 */
public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
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

	public List<Integer> majorityElement2(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> list = Arrays.stream(nums).boxed().collect(toList());
		Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
		return map.entrySet().parallelStream().filter(v -> v.getValue() >= (int) Math.floor(list.size() / 3.0) + 1)
				.map(Map.Entry::getKey).collect(toList());
	}

}