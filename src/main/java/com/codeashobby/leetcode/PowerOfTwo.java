/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

/**
 * Description: Given an integer, write a function to determine if it is a power of two.
 *
 * @author hzhou
 */
public class PowerOfTwo {

	public boolean isPowerOfTwo(int n) {
		int count = 0;
		if (n < 1) {
			return false;
		}
		for (int i = 0; i < 32; i++) {
			if ((n & 1) != 0) {
				count++;
			}
			if (count > 1) {
				return false;
			}
			n = n >> 1;
		}

		return count == 1;
	}
}