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