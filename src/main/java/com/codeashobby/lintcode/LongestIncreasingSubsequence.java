/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.lintcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class LongestIncreasingSubsequence {

	public int getLongestSubsequenceCount(int[] nums) {
		int length = nums.length;
		int[] dp = new int[length];
		List[] map = new ArrayList[length];

		int max = 0;
		for (int i = 0; i < length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] >= nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public int[] getLongestSubsequence(int[] nums) {
		int n = nums.length;
		int[] M = new int[n];
		int[] P = new int[n];
		int L = 0;

		for (int i = 1; i < n ; i++) {
			int j = 0;

			/** Linear search applied here. Binary Search can be applied too.
			 binary search for the largest positive j <= L such that
			 nums[M[j]] < nums[i] (or set j = 0 if no such value exists) **/

			for (int pos = L; pos >= 1; pos--) {
				if (nums[M[pos]] < nums[i]) {
					j = pos;
					break;
				}
			}
			P[i] = M[j];
			if (j == L || nums[i] < nums[M[j + 1]]) {
				M[j + 1] = i;
				L = Math.max(L, j + 1);
			}
		}

		/** backtrack **/

		int[] result = new int[L];
		int pos = M[L];
		for (int i = L - 1; i >= 0; i--) {
			result[i] = nums[pos];
			pos = P[pos];
		}
		return result;
	}

	@Test
	public void test() {
		int[] nums = new int[]{5, 3, 4, 8, 6, 7};
		int count = getLongestSubsequenceCount(nums);
		int[] result = getLongestSubsequence(nums);
	}

}