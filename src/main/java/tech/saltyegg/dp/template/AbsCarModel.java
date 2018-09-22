/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.template;

/**
 * Description:
 *
 * @author hzhou
 */
public abstract class AbsCarModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void engineBoom();

    protected abstract void alarm();

    protected boolean isAlarm() {
        return true;
    }

    public void run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }
}