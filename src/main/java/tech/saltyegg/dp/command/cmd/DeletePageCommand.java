/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.dp.command.cmd;

import tech.saltyegg.dp.command.Command;

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