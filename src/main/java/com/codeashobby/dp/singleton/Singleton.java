/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.singleton;

/**
 * Description:
 *
 * @author hzhou
 */
public class Singleton {

	private static Singleton ourInstance = new Singleton();

	public static Singleton getInstance() {
		return ourInstance;
	}

	private Singleton() {
	}
}