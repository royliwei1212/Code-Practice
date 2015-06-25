/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.command.cmd;

import com.codeashobby.dp.command.Command;

/**
 * Description:
 *
 * @author hzhou
 */
public class DeletePageCommand extends Command {

	@Override
	public void execute() {
		super.codeGroup.delete();
		// ...
	}
}