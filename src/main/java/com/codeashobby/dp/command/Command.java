/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.dp.command;

import com.codeashobby.dp.command.grp.CodeGroup;
import com.codeashobby.dp.command.grp.PageGroup;
import com.codeashobby.dp.command.grp.RequirementGroup;

/**
 * Description:
 *
 * @author hzhou
 */
public abstract class Command {

	protected CodeGroup codeGroup = new CodeGroup();
	protected RequirementGroup requirementGroup = new RequirementGroup();
	protected PageGroup pageGroup = new PageGroup();

	public abstract void execute();
}