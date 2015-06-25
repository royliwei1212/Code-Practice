/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.chain.handler;

import com.codeashobby.dp.chain.Handler;
import com.codeashobby.dp.chain.IWomen;
import com.codeashobby.dp.chain.RequestType;

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