/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author hzhou
 */

// TODO: not finished
public class WordLadderII {

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (start == null || end == null || dict == null || dict.isEmpty()) {
			return result;
		}

		dict.add(end);
		helper(start, end, new ArrayList<String>(), result, dict);
		return result;
	}

	private void helper(String start, String end, List<String> crt, List<List<String>> result, Set<String> dict) {
		if (start.equals(end)) {
			result.add(new ArrayList<String>(crt));
			return;
		}

		for () {

		}
	}
}