/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.state;

/**
 * Description:
 *
 * @author hzhou
 */
public abstract class LiftState {

	protected Context context;

	public void setContext(Context context) {
		this.context = context;
	}

	public abstract void open();

	public abstract void close();

	public abstract void run();

	public abstract void stop();
}