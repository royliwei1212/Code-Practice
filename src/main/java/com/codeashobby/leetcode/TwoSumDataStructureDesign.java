/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author hzhou
 */
public class TwoSumDataStructureDesign {

	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void add(int number) {
		int count = 1;
		if (map.containsKey(number)) {
			count += map.get(number);
		}
		map.put(number, count);
	}

	public boolean find(int value) {
		boolean result = false;
		for (int i : map.keySet()) {
			int left = value - i;
			if (i == left) {
				if (map.get(i) > 1) {
					result = true;
				}
			} else {
				result = map.containsKey(left);
			}

			if (result) {
				break;
			}
		}

		return result;
	}
}