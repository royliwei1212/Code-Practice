/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.factory.multiple;

import com.codeashobby.dp.factory.Human;
import com.codeashobby.dp.factory.YellowHuman;

/**
 * Description:
 *
 * @author hzhou
 */
public class YellowHumanFactory extends AbsHumanFactory {

	@Override
	public Human createHuman() {
		return new YellowHuman();
	}
}