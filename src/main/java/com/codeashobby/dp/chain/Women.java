/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.chain;

/**
 * Description:
 *
 * @author hzhou
 */
public class Women implements IWomen {

	private RequestType type;
	private String request;

	public Women(RequestType type, String request) {
		this.type = type;
		this.request = request;
	}

	public RequestType getType() {
		return this.type;
	}

	public String getRequest() {
		return this.request;
	}
}