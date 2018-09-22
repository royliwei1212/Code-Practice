/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.command;

/**
 * Description:
 *
 * @author hzhou
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void act() {
        this.command.execute();
    }
}