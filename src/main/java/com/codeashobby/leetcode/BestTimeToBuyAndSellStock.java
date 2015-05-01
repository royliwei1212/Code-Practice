package com.codeashobby.leetcode;

/**
 * Created by hzhou on 4/30/15. codeashobby@gmail.com
 */
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}

		int min = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			}

			if (max < prices[i] - min) {
				max = prices[i] - min;
			}
		}

		return max;
	}
}
