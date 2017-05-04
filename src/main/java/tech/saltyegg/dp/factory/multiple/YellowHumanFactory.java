/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.factory.multiple;

import tech.saltyegg.dp.factory.Human;
import tech.saltyegg.dp.factory.YellowHuman;

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