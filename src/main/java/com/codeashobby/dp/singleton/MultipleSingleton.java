/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:
 *
 * @author hzhou
 */
public class MultipleSingleton {

	private static final List<MultipleSingleton> instanceList = new ArrayList<>();
	private static final int COUNT = 2;

	static {
		for (int i = 0; i < COUNT; i++) {
			instanceList.add(new MultipleSingleton());
		}
	}

	private MultipleSingleton() {
	}

	// For demo usage
	public static MultipleSingleton getInstance() {
		Random random = new Random();
		return instanceList.get(random.nextInt(COUNT));
	}
}