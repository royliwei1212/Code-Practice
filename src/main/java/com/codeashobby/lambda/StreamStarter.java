/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.lambda;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static junit.framework.Assert.assertEquals;

/**
 * Description:
 *
 * @author hzhou
 */
public class StreamStarter {

	@Test
	public void streamMap() {
		List<String> collected = Stream.of("a", "b", "hello").map(String::toUpperCase).collect(toList());
		assertEquals(asList("A", "B", "HELLO"), collected);
	}

	@Test
	public void streamReduce() {
		int count = Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);
		assertEquals(6, count);
	}
}