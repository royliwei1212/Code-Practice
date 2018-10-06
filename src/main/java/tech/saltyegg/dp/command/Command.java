package tech.saltyegg.dp.command;

import tech.saltyegg.dp.command.grp.CodeGroup;
import tech.saltyegg.dp.command.grp.PageGroup;
import tech.saltyegg.dp.command.grp.RequirementGroup;

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