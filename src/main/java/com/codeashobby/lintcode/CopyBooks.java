/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.lintcode;

import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class CopyBooks {

	public int copyBooks(int[] pages, int k) {
		// write your code here
		int[][] dp = new int[k + 1][pages.length + 1];
		int sum = 0;
		int max = 0;
		for (int i = 1; i <= pages.length; i++) {
			sum += pages[i - 1];
			dp[1][i] = sum;
			max = Math.max(max, pages[i - 1]);
		}

		if (k >= pages.length) {
			return max;
		}

		for (int i = 2; i <= k; i++) {

			for (int j = pages.length - 1; j >= i - 1; j--) {
				int current = pages[j];
				int min = Math.max(pages[j], dp[i - 1][j]);
				dp[i][j + 1] = min;
				for (int l = j - 1; l >= i - 1; l--) {
					current += pages[l];
					int curMin = Math.max(current, dp[i - 1][l]);
					if (curMin < min) {
						dp[i][j + 1] = curMin;
						min = curMin;
					}
				}
			}
		}

		return dp[k][pages.length];
	}

	@Test
	public void test() {
		int[] pages = new int[]{11, 4, 2, 6, 13, 2, 3, 4, 2, 9, 12, 15};
		int result = copyBooks(pages, 5);
		System.out.println(result);
	}
}