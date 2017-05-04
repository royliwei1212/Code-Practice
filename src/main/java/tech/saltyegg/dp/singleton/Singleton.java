/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.singleton;

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