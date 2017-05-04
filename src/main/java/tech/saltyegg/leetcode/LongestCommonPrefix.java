/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

/**
 * Description
 *
 * @author hzhou
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		String s = strs[0];

		for (int i = 1; i < strs.length; i++) {
			s = helper(s, strs[i]);

			if (s.isEmpty()) {
				return "";
			}
		}

		return s;

	}

	private String helper(String s1, String s2) {
		int length = Math.min(s1.length(), s2.length());
		if (length == 0) {
			return "";
		}
		int i = 0;

		while (i < length && s1.charAt(i) == s2.charAt(i)) {
			i++;
		}

		return s1.substring(0, i);

	}
}