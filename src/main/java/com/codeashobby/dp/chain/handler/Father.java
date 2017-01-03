/**
 * Copyright (c) 2015 hzhou, All rights reserved.
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