package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Created by hzhou on 2015/5/28. Email: codeashobby@gmail.com
 *
 * // Note: leetcode test says words can have duplicated items
 */
public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || words == null) {
			return result;
		}

		int wordLength = words[0].length();
		int totalLength = wordLength * words.length;
		if (s.length() < totalLength) {
			return result;
		}
		Set<String> set = getSet(words);
		for (int i = 0; i <= s.length() - totalLength; i++) {
			String tmp = s.substring(i, i + wordLength);
			if (set.contains(tmp) && check(s.substring(i, i + totalLength), words)) {
				result.add(i);
			}
		}

		return result;
	}

	private Set<String> getSet(String[] words) {
		Set<String> result = new HashSet<String>();
		Collections.addAll(result, words);
		return result;
	}

	private boolean check(String s, String[] words) {
		Set<String> set = getSet(words);
		int length = words[0].length();
		for (int i = 0; i <= s.length() - length; i = i + length) {
			String tmp = s.substring(i, i + length);
			if (!set.contains(tmp)) {
				return false;
			} else {
				set.remove(tmp);
			}
		}
		return set.isEmpty();
	}

	@Test
	public void test() {
		String s = "barfoothefoobarman";
		String[] words = new String[]{"foo", "bar"};
		List<Integer> result = findSubstring(s, words);
	}

}
