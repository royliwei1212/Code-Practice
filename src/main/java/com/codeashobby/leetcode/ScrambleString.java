/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

/**
 * Description:
 *
 * @author hzhou
 */
public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if (!isAnagram(s1, s2)) {
			return false;
		}
		int length = s1.length();
		for (int i = 1; i < length; i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, length);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, length);
			if (isScramble(s11, s21) && isScramble(s12, s22)) {
				return true;
			}
			s21 = s2.substring(0, length - i);
			s22 = s2.substring(length - i, length);

			if (isScramble(s11, s22) && isScramble(s12, s21)) {
				return true;
			}
		}

		return false;
	}

	private boolean isAnagram(String s1, String s2) {
		if (s1 == s2 || s1.equals(s2)) {
			return true;
		}

		if (s1.length() != s2.length()) {
			return false;
		}

		int[] chars = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			chars[s1.charAt(i) - 'a']++;
			chars[s2.charAt(i) - 'a']--;
		}

		for (int i : chars) {
			if (i != 0) {
				return false;
			}
		}

		return true;
	}
}