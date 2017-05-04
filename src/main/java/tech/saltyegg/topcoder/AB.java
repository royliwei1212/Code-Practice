/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.topcoder;

import org.junit.Test;

/**
 * Description: You are given two s: N and K. Lun the dog is interested in strings that satisfy the following
 * conditions:
 * <p>
 * The string has exactly N characters, each of which is either 'A' or 'B'.
 * <p>
 * The string has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'. If there exists a
 * string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 *
 * @author hzhou
 */
public class AB {

	public String createString(int N, int K) {
		if (N < 1 || K < 0 || K > (N / 2.0) * (N / 2.0)) {
			return "";
		}

		if (K == 0) {
			return strFactory('A', N);
		}

		StringBuilder sb = new StringBuilder();
		int a = 1;
		while (a <= N / 2) {
			int x = N - a;
			if (K == a * x) {
				return strFactory('A', a) + strFactory('B', N - a);
			}

			if (K > (a - 1) * (x + 1) && K < a * x) {
				break;
			}
			a++;
		}

		// divide K into a parts
		int last = K % (N-a);
		if (last != 0) {
			sb.append(strFactory('A', a - 1)).append(strFactory('B', N - a - last)).append('A')
					.append(strFactory('B', last));
		} else {
			sb.append(strFactory('A', a)).append(strFactory('B', N - a));
		}

		return sb.toString();
	}

	private String strFactory(char c, int count) {
		StringBuilder sb = new StringBuilder();
		while (count > 0) {
			sb.append(c);
			count--;
		}
		return sb.toString();
	}

	@Test
	public void test() {
		String x = createString(10, 15);
		x = createString(10, 12);
	}
}