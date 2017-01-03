/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		helper(result, new ArrayList<Integer>(), 0, target, candidates);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> crt, int start, int target, int[] candidates) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(crt));
			return;
		}
		if (target < 0) {
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			crt.add(candidates[i]);
			helper(result, crt, i, target - candidates[i], candidates);
			crt.remove(crt.size() - 1);
		}
	}

	@Test
	public void test() {
		int[] nums = new int[]{2, 3, 6, 7};
		List<List<Integer>> result = combinationSum(nums, 7);
	}

}