package tech.saltyegg.dp.factory;

import org.apache.log4j.Logger;

/**
 * Description:
 *
 * @author hzhou
 */
public class BlackHuman implements Human {

    private static final Logger log = Logger.getLogger(BlackHuman.class);

    @Override
    public void getColor() {
        log.info("I am black");
    }

    @Override
    public void talk() {
        log.info("I like rap");
    }
}