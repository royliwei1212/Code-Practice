/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.state.states;

import com.codeashobby.dp.state.Context;
import com.codeashobby.dp.state.LiftState;

/**
 * Description:
 *
 * @author hzhou
 */
public class OpeningState extends LiftState {

	@Override
	public void open() {
		System.out.println("Door is opening ...");
	}

	@Override
	public void close() {
		super.context.setLiftState(Context.closingState);
		super.context.getLiftState().close();
	}

	@Override
	public void run() {
		// do nothing
	}

	@Override
	public void stop() {
		// do nothing
	}
}