package com.codeashobby.leetcode;

/**
 * Created by hzhou on 4/22/15. codeashobby@gmail.com
 */
public class RotateArray {

	public void rotate(int[] nums, int k) {
		int length = nums.length;
		if (length == 0) {
			return;
		}

		k = k % length;

		if (k == 0) {
			return;
		}

		int[] tmp = new int[k];
		int j = 0;
		// load data to tmp array
		for (int i = length - k; i < length; i++) {
			tmp[j++] = nums[i];
		}

		for (int i = length - 1 - k; i >= 0; i--) {
			nums[i + k] = nums[i];
		}

		for (int i = 0; i < k; i++) {
			nums[i] = tmp[i];
		}
	}
}
