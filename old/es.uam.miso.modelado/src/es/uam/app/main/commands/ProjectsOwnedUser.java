package es.uam.app.main.commands;

import java.util.List;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public class ProjectsOwnedUser extends MainCommand implements DataFormat{


	public ProjectsOwnedUser() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
	
		User u=searchUser(rm.getUserToSearch());
		List<Project> list = SocioData.getSocioData().getProjects(u);
		
		throw new SendMessageExc(this.printOwnProject(u, list));
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
