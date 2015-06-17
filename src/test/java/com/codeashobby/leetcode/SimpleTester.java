/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class SimpleTester {

	private static final Logger log = Logger.getLogger(SimpleTester.class);

	@Test
	public void UUIDCast() throws URISyntaxException {
		StringBuilder sb = new StringBuilder();
		sb.append(UUID.randomUUID()).append(',');
		sb.append(UUID.randomUUID()).append(',');
		sb.append(UUID.randomUUID()).append(',');
		sb.append(UUID.randomUUID()).append(',');
		List value = getValues(sb.toString(), UUID.class);

		log.info(new URI("2"));
	}

	@Test
	public void DoubleCase() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(r.nextDouble()).append(',');
		}
		List value = getValues(sb.toString(), Double.class);
	}

	private <T> List<T> getValues(String valueString, Class<T> clazz) {
		List<String> values = Lists.newArrayList(Splitter.on(',').omitEmptyStrings().trimResults().split(valueString));
		List<T> result = new ArrayList<T>();
		if (clazz.equals(UUID.class)) {
			log.info("I am UUID type...");
			for (String s : values) {
				result.add((T) UUID.fromString(s));
			}
		} else {

			for (String s : values) {
				result.add(clazz.cast(s));
			}
		}

		//return new ArrayList<String>();
		return result;
	}

	@Test
	public void enumTest() {
		Container c1 = new Container(Type.TP1, UUID.randomUUID());
		c1.setC(new Container(Type.TP1, UUID.randomUUID()));
		Container c2 = c1.deepCopy();
		c2.setType(Type.TP2);
		c2.setId(UUID.randomUUID());

	}

	@Test
	public void intTest() {

	}
}