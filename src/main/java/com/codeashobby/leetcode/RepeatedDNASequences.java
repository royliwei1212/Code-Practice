/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Description
 *
 * @author hzhou
 */
public class RepeatedDNASequences {

	//TODO: wrong answer
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.isEmpty() || s.length() < 10) {
			return result;
		}

		for (int i = 0; i < s.length() - 10; i++) {
			String tmp = s.substring(i, i + 10);
			if (s.indexOf(tmp, i + 1) != -1) {
				result.add(tmp);
			}
		}
		return result;
	}

	@Test
	public void test() {
		List<String> result = findRepeatedDnaSequences("AAAAAAAAAAA");
	}
}