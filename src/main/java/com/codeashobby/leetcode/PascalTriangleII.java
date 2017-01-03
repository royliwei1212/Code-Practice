/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author hzhou
 */
public class PascalTriangleII {

	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			return new ArrayList<Integer>();
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i <= rowIndex; i++) {
			list.add(helper(i, list));
		}

		return list.get(rowIndex);
	}

	private List<Integer> helper(int num, List<List<Integer>> list) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		if (num > 0) {
			List<Integer> tmp = list.get(num - 1);
			for (int i = 0; i < tmp.size() - 1; i++) {
				result.add(tmp.get(i) + tmp.get(i + 1));
			}
			result.add(1);
		}

		return result;
	}
}