package com.codeashobby.leetcode;

import java.util.Arrays;

/**
 * Created by hzhou on 4/23/15. codeashobby@gmail.com
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		assert nums.length > 0;
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
}
