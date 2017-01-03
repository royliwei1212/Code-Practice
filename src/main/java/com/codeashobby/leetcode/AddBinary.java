/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import org.junit.Test;

/**
 * Description:Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example, a = "11" b = "1" Return "100".
 *
 * @author hzhou
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		if (a == null || a.trim().isEmpty()) {
			return b;
		}

		if (b == null || b.trim().isEmpty()) {
			return a;
		}

		a = a.trim();
		b = b.trim();

		// make a is the longer string, b is the shorter one
		if (a.length() < b.length()) {
			String tmp = b;
			b = a;
			a = tmp;
		}
		// a is the longer one
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		boolean inc = false;
		for (; j >= 0; j--, i--) {
			int ia = a.charAt(i) - '0';
			int ib = b.charAt(j) - '0';
			int sum = ia + ib + (inc ? 1 : 0);
			sb.insert(0, sum % 2);
			inc = sum > 1;
		}

		while (i >= 0) {
			int sum = a.charAt(i) - '0' + (inc ? 1 : 0);
			sb.insert(0, sum % 2);
			inc = sum > 1;
			i--;
		}

		if (i < 0 && inc) {
			sb.insert(0, '1');
		}

		return sb.toString();
	}

	@Test
	public void test() {
		String result = addBinary("1", "11");
	}
}