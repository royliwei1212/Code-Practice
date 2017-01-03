/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.singleton;

/**
 * Description:
 *
 * @author hzhou
 */
public enum BetterSingleton {
	INSTANCE;

	public void doStuff() {
		System.out.println("Singleton using Enum");
	}

}