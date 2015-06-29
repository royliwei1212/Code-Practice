/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

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

	@Test
	public void counter() {

		int[] nums = null;
		List<Integer> list = Arrays.stream(nums).boxed().collect(toList());
		Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
		List<Integer> result = map.entrySet().parallelStream()
				.filter(v -> v.getValue() >= (int) Math.floor(list.size() / 3.0) + 1).map(Map.Entry::getKey)
				.collect(toList());
	}

}