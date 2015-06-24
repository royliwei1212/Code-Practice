/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.factory;

import org.apache.log4j.Logger;

/**
 * Description:
 *
 * @author hzhou
 */
public class YellowHuman implements Human {

	private static final Logger log = Logger.getLogger(YellowHuman.class);

	@Override
	public void getColor() {
		log.info("I am yellow");
	}

	@Override
	public void talk() {
		log.info("I like food");
	}
}