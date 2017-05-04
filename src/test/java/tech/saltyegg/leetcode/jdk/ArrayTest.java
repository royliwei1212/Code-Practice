/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode.jdk;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class ArrayTest {

	private static final Logger log = Logger.getLogger(ArrayTest.class);

	@Test
	public void array2List() {
		int[] data = new int[]{1, 2, 3, 4, 5};
		//List<Integer> list = Arrays.asList(data);
		List list = Arrays.asList(data);
	}

	@Test
	public void hashCodeTest() {
		for (int i = 0; i < 50; i++) {
			// if I remove the third parameter, it works fine
			//log.info(Arrays.hashCode("getDemoCache", "1", new int[]{1, 2}));
		}
	}

	@Test
	public void hashCodeTest2() {
		int[] arr = new int[]{1, 2};
		for (int i = 0; i < 50; i++) {
			// if I remove the third parameter, it works fine
			log.info(Objects.hash("getDemoCache", "1", arr));
		}
	}
}