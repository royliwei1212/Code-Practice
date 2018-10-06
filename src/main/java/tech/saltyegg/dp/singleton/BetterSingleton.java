package tech.saltyegg.dp.singleton;

/**
 * Description:
 *
 * @author hzhou
 */
public enum BetterSingleton {
    INSTANCE;

    public void doStuff() {
        System.out.println("Singleton using Enum");
    }

}