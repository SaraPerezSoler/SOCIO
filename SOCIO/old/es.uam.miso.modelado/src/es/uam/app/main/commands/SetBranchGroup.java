package es.uam.app.main.commands;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class SetBranchGroup extends MainCommand {

	public SetBranchGroup() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual=searchProject(rm);
		if (!actual.isBranch()){
			throw new SendMessageExc("The project must be a branch to set a group.");
		}
		
		if (!rm.getUser().canEdit(actual)){
			throw new NotAccessException("You need write permissions");
		}
		actual.setBranchGroup(rm.getText());
		throw new SendMessageExc("The project "+ actual.getName()+" now belongs to the branch group "+actual.getBranchGroup());

	}

	@Override
	public String getName() {
		return "SET_BRANCH_GROUP";
	}

	@Override
	public String getDesc() {
		return "Set a branch group name in a branch project";
	}

	@Override
	public String getNeeds() {
		return project()+", the group name in text field";
	}

}
