package es.uam.app.main.commands;

import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class SelectBranch extends MainCommand {

	public SelectBranch() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "SELECT_BRANCH";
	}

	@Override
	public String getDesc() {
		return "Select a branch of a group branch to the project";
	}

	@Override
	public String getNeeds() {

		return project()+", the branch in the field text";
	}

}
