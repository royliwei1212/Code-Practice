/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.state;

import com.codeashobby.dp.state.states.ClosingState;

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