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
public class StoppingState extends LiftState {

	@Override
	public void open() {
		super.context.setLiftState(Context.openingState);
		super.context.getLiftState().open();
	}

	@Override
	public void close() {
		// do nothing, as door is already closed
	}

	@Override
	public void run() {
		super.context.setLiftState(Context.runningState);
		super.context.getLiftState().run();
	}

	@Override
	public void stop() {
		System.out.println("Life is stopping ...");
	}
}