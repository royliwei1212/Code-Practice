package tech.saltyegg.dp.state;

import tech.saltyegg.dp.state.states.ClosingState;

/**
 * Description:
 *
 * @author hzhou
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}