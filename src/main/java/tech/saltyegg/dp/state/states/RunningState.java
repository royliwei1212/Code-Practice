/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.state.states;

import tech.saltyegg.dp.state.Context;
import tech.saltyegg.dp.state.LiftState;

/**
 * Description:
 *
 * @author hzhou
 */
public class RunningState extends LiftState {

	@Override
	public void open() {
		// do nothing
	}

	@Override
	public void close() {
		// do nothing
	}

	@Override
	public void run() {
		System.out.println("Lift is running");
	}

	@Override
	public void stop() {
		super.context.setLiftState(Context.stoppingState);
		super.context.getLiftState().stop();
	}
}