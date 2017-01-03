/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.factory.multiple;

import com.codeashobby.dp.factory.Human;
import com.codeashobby.dp.factory.WhiteHuman;

/**
 * Description:
 *
 * @author hzhou
 */
public class WhiteHumanFactory extends AbsHumanFactory {

	@Override
	public Human createHuman() {
		return new WhiteHuman();
	}
}