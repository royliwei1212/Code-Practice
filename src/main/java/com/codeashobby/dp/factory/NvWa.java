/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.factory;

import com.codeashobby.dp.factory.simple.StaticHumanFactory;

/**
 * Description:
 *
 * @author hzhou
 */
public class NvWa {

	public static void main(String[] args) {
		AbsHumanFactory yinYangLu = new HumanFactory();
		//Human human = yinYangLu.createHuman(WhiteHuman.class);
		Human human = StaticHumanFactory.createHuman(WhiteHuman.class);
		human.getColor();
		human.talk();
	}
}