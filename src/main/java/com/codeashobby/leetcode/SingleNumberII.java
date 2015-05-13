package com.codeashobby.leetcode;

/**
 * Created by hzhou on 5/12/15. codeashobby@gmail.com
 */
public class SingleNumberII {

	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0, threes = 0;
		for (int num : nums) {
			twos |= ones & num;
			ones ^= num;
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
}
