/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.factory.multiple;

import tech.saltyegg.dp.factory.Human;
import tech.saltyegg.dp.factory.WhiteHuman;

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