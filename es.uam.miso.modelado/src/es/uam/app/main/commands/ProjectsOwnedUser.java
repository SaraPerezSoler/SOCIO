package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.User;

public class ProjectsOwnedUser extends MainCommand {


	public ProjectsOwnedUser() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
	
		User u=searchUser(rm.getUserToSearch());
		String list = SocioData.getSocioData().getProjectForUser(u);
		throw new SendMessageExc(list);
	}

	@Override
	public String getName() {
		return "PROJECTS_OWN";
	}

	@Override
	public String getDesc() {
		return "all projects which belong to a user";
	}

	@Override
	public String getNeeds() {
		return userToSearch();
	}

}
