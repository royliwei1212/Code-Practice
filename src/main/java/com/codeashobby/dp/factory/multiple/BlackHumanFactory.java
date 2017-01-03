/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.factory.multiple;

import com.codeashobby.dp.factory.BlackHuman;
import com.codeashobby.dp.factory.Human;

/**
 * Description:
 *
 * @author hzhou
 */
public class BlackHumanFactory extends AbsHumanFactory {

	@Override
	public Human createHuman() {
		return new BlackHuman();
	}
}