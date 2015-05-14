package com.codeashobby.leetcode;

import org.junit.Test;

/**
 * Created by hzhou on 5/10/15. codeashobby@gmail.com
 * <p/>
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p/>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p/>
 * For example,
 * <p/>
 * Given numerator = 1, denominator = 2, return "0.5".
 * <p/>
 * Given numerator = 2, denominator = 1, return "2".
 * <p/>
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return "";
		}
		int pos = 1;
		if (numerator / denominator < 0) {
			pos = -1;
		}
		long n = Math.abs(numerator);
		long d = Math.abs(denominator);
		StringBuffer sb = new StringBuffer();


		return null;
	}

	@Test
	public void test() {
		String result = fractionToDecimal(76, 7);
	}
}
