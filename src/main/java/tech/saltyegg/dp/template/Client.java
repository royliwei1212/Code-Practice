/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.template;

/**
 * Description:
 *
 * @author hzhou
 */
public class Client {

    public static void main(String[] args) {
        CarOne carOne = new CarOne();
        carOne.setAlarm(true);
        carOne.run();

        CarTwo carTwo = new CarTwo();
        carTwo.run();
    }
}