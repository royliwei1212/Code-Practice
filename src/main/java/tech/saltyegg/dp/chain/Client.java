/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.chain;

import java.util.ArrayList;
import java.util.List;

import tech.saltyegg.dp.chain.handler.Father;
import tech.saltyegg.dp.chain.handler.Husband;
import tech.saltyegg.dp.chain.handler.Son;

/**
 * Description:
 *
 * @author hzhou
 */
public class Client {

    public static void main(String[] args) {
        RequestType[] types = RequestType.values();
        List<IWomen> list = new ArrayList<IWomen>();
        for (RequestType type : types) {
            list.add(new Women(type, "test request string"));
        }

        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        father.setNext(husband);
        husband.setNext(son);

        for (IWomen women : list) {
            father.handleMessage(women);
        }
    }
}