/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Description: There are N children standing in a line. Each child is assigned a rating value.
 * <p/>
 * You are giving candies to these children subjected to the following requirements:
 * <p/>
 * Each child must have at least one candy. Children with a higher rating get more candies than their neighbors. What is
 * the minimum candies you must give?
 *
 * http://www.programcreek.com/2014/03/leetcode-candy-java/
 *
 * @author hzhou
 */
public class Candy {

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int[] count = new int[ratings.length];
		for (int i = 0; i < count.length; i++) {
			count[i] = 1;
		}

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				count[i] = count[i - 1] + 1;
			}
		}
		int result = 0;

		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				count[i] = Math.max(count[i], count[i + 1] + 1);
			}
		}
		for (int i : count) {
			result += i;
		}
		return result;
	}

	@Test
	public void test() {
		int[] ratings = new int[]{4, 2, 3, 4, 1};
		assertSame(9, candy(ratings));
	}
}