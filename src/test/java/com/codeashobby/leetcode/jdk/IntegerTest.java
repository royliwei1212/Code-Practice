package com.codeashobby.leetcode.jdk;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hzhou on 8/15/15. codeashobby@gmail.com
 */
public class IntegerTest {

	private static final Logger log = Logger.getLogger(IntegerTest.class);

	@Test
	public void integerValueOfTest() {
		Assert.assertTrue(Integer.valueOf(-128) == Integer.valueOf(-128));
		Assert.assertFalse(Integer.valueOf(128) == Integer.valueOf(128));
		Assert.assertTrue(Integer.valueOf(127) == Integer.valueOf(127));
		Assert.assertTrue(Integer.valueOf(1) == Integer.valueOf(1));
		Assert.assertFalse(Integer.valueOf(1000) == Integer.valueOf(1000));
	}
}
