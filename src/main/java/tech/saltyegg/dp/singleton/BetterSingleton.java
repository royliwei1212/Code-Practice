/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
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