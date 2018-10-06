package tech.saltyegg.dp.factory;

/**
 * Description:
 *
 * @author hzhou
 */
public abstract class AbsHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> clz);
}