/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.chain.handler;

import tech.saltyegg.dp.chain.Handler;
import tech.saltyegg.dp.chain.IWomen;
import tech.saltyegg.dp.chain.RequestType;

/**
 * Description:
 *
 * @author hzhou
 */
public class Husband extends Handler {

	public Husband() {
		super(RequestType.HUSBAND_LEVEL);
	}

	@Override
	public void response(IWomen women) {
		System.out.println(women.getRequest());
		System.out.println("Husband handles request now...");
	}
}