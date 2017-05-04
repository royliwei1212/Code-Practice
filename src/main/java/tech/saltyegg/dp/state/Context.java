/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.state;

import tech.saltyegg.dp.state.states.ClosingState;
import tech.saltyegg.dp.state.states.OpeningState;
import tech.saltyegg.dp.state.states.RunningState;
import tech.saltyegg.dp.state.states.StoppingState;

/**
 * Description:
 *
 * @author hzhou
 */
public class Context {

	public static final OpeningState openingState = new OpeningState();
	public static final ClosingState closingState = new ClosingState();
	public static final RunningState runningState = new RunningState();
	public static final StoppingState stoppingState = new StoppingState();

	private LiftState liftState;

	public LiftState getLiftState() {
		return liftState;
	}

	public void setLiftState(LiftState liftState) {
		this.liftState = liftState;
		this.liftState.setContext(this);
	}

	public void open() {
		this.liftState.open();
	}

	public void close() {
		this.liftState.close();
	}

	public void run() {
		this.liftState.run();
	}

	public void stop() {
		this.liftState.stop();
	}
}