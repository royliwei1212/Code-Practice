package tech.saltyegg.dp.factory.multiple;

import tech.saltyegg.dp.factory.BlackHuman;
import tech.saltyegg.dp.factory.Human;

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