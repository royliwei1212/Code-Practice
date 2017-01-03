/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.dp.chain;

import java.util.ArrayList;
import java.util.List;

import com.codeashobby.dp.chain.handler.Father;
import com.codeashobby.dp.chain.handler.Husband;
import com.codeashobby.dp.chain.handler.Son;

/**
 * Description:
 *
 * @author hzhou
 */
public class Client {

	public static void main(String[] args) {
		RequestType[] types = RequestType.values();
		List<IWomen> list = new ArrayList<IWomen>();
		for (RequestType type : types) {
			list.add(new Women(type, "test request string"));
		}

		Handler father = new Father();
		Handler husband = new Husband();
		Handler son = new Son();

		father.setNext(husband);
		husband.setNext(son);

		for (IWomen women : list) {
			father.handleMessage(women);
		}
	}
}