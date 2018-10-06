package tech.saltyegg.dp.factory;

import org.apache.log4j.Logger;

/**
 * Description:
 *
 * @author hzhou
 */
public class HumanFactory extends AbsHumanFactory {

    private static final Logger log = Logger.getLogger(HumanFactory.class);

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Human> T createHuman(Class<T> clz) {
        T human = null;
        try {
            human = (T) Class.forName(clz.getName()).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            log.error(e);
        }
        return human;
    }
}