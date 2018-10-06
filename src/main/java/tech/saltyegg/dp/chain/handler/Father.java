package tech.saltyegg.dp.chain.handler;

import tech.saltyegg.dp.chain.Handler;
import tech.saltyegg.dp.chain.IWomen;
import tech.saltyegg.dp.chain.RequestType;

/**
 * Description:
 *
 * @author hzhou
 */
public class Father extends Handler {

    public Father() {
        super(RequestType.FATHER_LEVEL);
    }

    @Override
    public void response(IWomen women) {
        System.out.println(women.getRequest());
        System.out.println("Father handles request now...");
    }
}