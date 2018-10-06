package tech.saltyegg.dp.state.states;

import tech.saltyegg.dp.state.Context;
import tech.saltyegg.dp.state.LiftState;

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