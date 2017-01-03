/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.chain;

import org.jetbrains.annotations.NotNull;

/**
 * Description:
 *
 * @author hzhou
 */
public abstract class Handler {

	private Handler nextHandler;
	private RequestType type;

	public Handler(RequestType type) {
		this.type = type;
	}

	public final void handleMessage(@NotNull IWomen women) {
		if (women.getType() == this.type) {
			this.response(women);
		} else {
			if (this.nextHandler != null) {
				this.nextHandler.handleMessage(women);
			} else {
				System.out.println("No more next handler now, will not handle it ...");
			}
		}
	}

	public void setNext(Handler handler) {
		this.nextHandler = handler;
	}

	public abstract void response(IWomen women);
}