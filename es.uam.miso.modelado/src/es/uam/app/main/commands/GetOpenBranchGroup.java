package es.uam.app.main.commands;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class GetOpenBranchGroup extends MainCommand {

	public GetOpenBranchGroup() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual=searchProject(rm);
		
		if (!rm.getUser().canRead(actual)){
			throw new NotAccessException("Needs read permision");
		}
		if (actual.isBranch()){
			throw new SendMessageExc("A branch doesn't have branchs");
		}
		String branchGroup=actual.getAllOpenBranchsGroup();
		throw new SendMessageExc(branchGroup); 

	}

	@Override
	public String getName() {
		return "GET_OPEN_BRANCH_GROUP";
	}

	@Override
	public String getDesc() {
		return "get all the open branch group of a project";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
