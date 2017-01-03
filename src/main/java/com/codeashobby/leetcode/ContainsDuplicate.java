/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Given an array of integers, find if the array contains any duplicates. Your function should return true
 * if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * @author hzhou
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return false;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (set.contains(i)) {
				return true;
			} else {
				set.add(i);
			}
		}
		return false;
	}
}