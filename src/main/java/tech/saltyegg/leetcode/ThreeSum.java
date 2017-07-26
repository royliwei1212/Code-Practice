package tech.saltyegg.leetcode;

import java.util.*;

/**
 * Created by hzhou on 5/4/15. codeashobby@gmail.com
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		int length = nums.length;
		for (int i = 0; i < length - 2; i++) {
			for (int j = i + 1; j < length - 1; j++) {
				int s = 0 - nums[i] - nums[j];
				if (s < nums[j] || s > nums[length - 1]) {
					continue;
				}
				if (helper(j + 1, length - 1, nums, s)) {
					List<Integer> r = new ArrayList<>();
					r.add(nums[i]);
					r.add(nums[j]);
					r.add(s);
					result.add(r);
				}

			}
		}
		return new ArrayList<>(result);
	}

	private boolean helper(int start, int end, int[] nums, int target) {
		while (start <= end) {
			int middle = (start + end) / 2;
			if (nums[middle] == target) {
				return true;
			}
			if (nums[middle] > target) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}

		}

		return false;
	}
}
