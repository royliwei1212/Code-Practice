/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.template;

/**
 * Description:
 *
 * @author hzhou
 */
public class Client {

	public static void main(String[] args) {
		CarOne carOne = new CarOne();
		carOne.setAlarm(true);
		carOne.run();

		CarTwo carTwo = new CarTwo();
		carTwo.run();
	}
}