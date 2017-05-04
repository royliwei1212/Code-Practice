/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.template;

/**
 * Description:
 *
 * @author hzhou
 */
public class CarOne extends AbsCarModel {

	private boolean isAlarm = false;

	@Override
	protected void start() {
		System.out.println("car 1 starts ...");
	}

	@Override
	protected void stop() {
		System.out.println("car 1 stops ...");
	}

	@Override
	protected void engineBoom() {
		System.out.println("car 1 engine booms ...");
	}

	@Override
	protected void alarm() {
		System.out.println("car 1 alarms ...");
	}

	@Override
	protected boolean isAlarm() {
		return this.isAlarm;
	}

	public void setAlarm(boolean isAlarm) {
		this.isAlarm = isAlarm;
	}
}