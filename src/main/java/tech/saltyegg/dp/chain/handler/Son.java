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
public class Son extends Handler {

	public Son() {
		super(RequestType.SON_LEVEL);
	}

	@Override
	public void response(IWomen women) {
		System.out.println(women.getRequest());
		System.out.println("Son handles request now...");
	}
}