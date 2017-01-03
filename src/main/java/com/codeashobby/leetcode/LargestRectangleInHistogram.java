/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
 * Description: TODO: This is a hard question
 *
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 *
 * @author hzhou
 */
public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int[] arr = Arrays.copyOf(height, height.length + 1);

		int crt = 0;
		int max = 0;
		while (crt < arr.length) {
			if (stack.isEmpty() || arr[crt] >= arr[stack.peek()]) {
				stack.push(crt++);
			} else {
				int i = stack.pop();
				max = Math.max(max, arr[i] * (stack.isEmpty() ? crt : crt - stack.peek() - 1));
			}
		}

		return max;
	}

	@Test
	public void test() {
		int[] nums = new int[]{3, 3, 2, 2};
		int result = largestRectangleArea(nums);
	}
}