package tech.saltyegg.dp.factory;

import org.apache.log4j.Logger;

/**
 * Description:
 *
 * @author hzhou
 */
public class YellowHuman implements Human {

    private static final Logger log = Logger.getLogger(YellowHuman.class);

    @Override
    public void getColor() {
        log.info("I am yellow");
    }

    @Override
    public void talk() {
        log.info("I like food");
    }
}