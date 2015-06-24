/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.factory;

/**
 * Description:
 *
 * @author hzhou
 */
public class NvWa {

	public static void main(String[] args) {
		AbsHumanFactory yinYangLu = new HumanFactory();
		Human human = yinYangLu.createHuman(WhiteHuman.class);
		human.getColor();
		human.talk();
	}
}