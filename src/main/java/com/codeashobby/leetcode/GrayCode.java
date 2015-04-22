package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by hzhou on 4/21/15. codeashobby@gmail.com
 */
public class GrayCode {

	private static final Logger log = Logger.getLogger(GrayCode.class);

	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		for (int i = 0; i < n; i++) {
			int inc = 1 << i;
			for (int j = result.size() - 1; j >= 0; j--) {
				result.add(result.get(j) + inc);
			}
		}
		return result;
	}

	@Test
	public void test() {

	}
}
