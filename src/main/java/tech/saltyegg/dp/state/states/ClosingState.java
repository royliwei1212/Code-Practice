package tech.saltyegg.dp.state.states;

import tech.saltyegg.dp.state.Context;
import tech.saltyegg.dp.state.LiftState;

/**
 * Description:
 *
 * @author hzhou
 */
public class ClosingState extends LiftState {

    @Override
    public void open() {
        super.context.setLiftState(Context.openingState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        System.out.println("Door is closing ...");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}