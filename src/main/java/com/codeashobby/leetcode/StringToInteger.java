/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import org.junit.Test;

/**
 * Description
 *
 * @author hzhou
 */
public class StringToInteger {

	public int myAtoi(String str) {
		if (str == null || str.trim().isEmpty()) {
			return 0;
		}
		str = str.trim();
		int result = 0;
		boolean positive = true;
		int i = 0;
		for (; i < str.length(); i++) {
			char c = str.charAt(i);
			if (isNumber(c) || c == '-' || c == '+') {
				break;
			} else {
				return 0;
			}
		}
		// processed str
		if (i == str.length()) {
			return 0;
		}
		str = str.substring(i, str.length());
		if (str.charAt(0) == '-') {
			positive = false;
			str = str.substring(1, str.length());
		}

		if (str.charAt(0) == '+') {
			positive = true;
			str = str.substring(1, str.length());
		}

		// now we can get a string for a positive number
		if (str.length() > 10 || str.isEmpty()) {
			return 0;
		}

		for (i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (isNumber(c)) {
				try {
					result = overFlowCheck(positive, result, c);
				} catch (Exception e) {
					return 0;
				}
			} else {
				return 0;
			}
		}

		return result;
	}

	private boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	private int overFlowCheck(boolean positive, int result, char c) throws Exception {
		if (positive) {
			if (Integer.MAX_VALUE - (c - '0') < result * 10) {
				throw new Exception("Overflow");
			} else {
				result = result * 10 + (c - '0');
			}
		} else {
			if (Integer.MIN_VALUE + (c - '0') > result * 10) {
				throw new Exception("Overflow");
			} else {
				result = result * 10 - (c - '0');
			}
		}
		return result;
	}

	@Test
	public void test() {
		System.out.println(myAtoi("-212121"));
		System.out.println(myAtoi(String.valueOf(Integer.MAX_VALUE)));
		System.out.println(myAtoi(String.valueOf(Integer.MIN_VALUE)));
		System.out.println(myAtoi("-2147483649"));
		System.out.println(myAtoi("2147483649"));

	}
}