/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.factory.singleton;

import java.lang.reflect.Constructor;

/**
 * Description:
 *
 * @author hzhou
 */
@SuppressWarnings({"unchecked", "CallToPrintStackTrace", "StaticNonFinalField"})
public class SingletonFactory {

    private static Singleton singleton = null;

    static {
        try {
            Class clz = Class.forName(Singleton.class.getName());
            Constructor constructor = clz.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}