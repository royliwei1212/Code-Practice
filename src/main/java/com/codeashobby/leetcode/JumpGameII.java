/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import org.junit.Test;

/**
 * Description: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p/>
 * For example: Given array A = [2,3,1,1,4]
 * <p/>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.)
 *
 * @author hzhou
 */
public class JumpGameII {

	public int jump(int[] nums) {

		if (nums == null || nums.length < 1) {
			return nums == null ? 0 : nums.length;
		}
		int[] map = new int[nums.length];
		for (int i = 0; i < map.length; i++) {
			map[i] = Integer.MAX_VALUE;
		}
		map[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= i + nums[i] && j < map.length; j++) {
				map[j] = Math.min(map[j], map[i] + 1);
			}
		}

		return map[nums.length - 1];
	}

	@Test
	public void test() {
		int[] nums = new int[]{2, 3, 1, 1, 4};
		int result = jump(nums);
	}
}