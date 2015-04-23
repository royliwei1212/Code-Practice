package com.codeashobby.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hzhou on 4/22/15. codeashobby@gmail.com
 */
public class HappyNumber {

	public boolean isHappy(int n) {
		assert n >= 0;

		Set<Integer> history = new HashSet<Integer>();
		int tmp = calculator(n);
		history.add(tmp);

		while (true) {
			if (tmp == 1) {
				return true;
			} else {
				tmp = calculator(tmp);
				if (history.contains(tmp)) {
					return false;
				} else {
					history.add(tmp);
				}
			}

		}
	}

	private int calculator(int n) {
		int result = 0;
		while (n > 0) {
			int mod = n % 10;
			result += mod * mod;
			n = n / 10;
		}

		return result;
	}
}
