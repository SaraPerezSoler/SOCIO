package es.uam.app.main.commands;

import java.util.List;

import es.uam.app.main.SocioData;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public class UsersInAProject extends MainCommand {

	public UsersInAProject() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual = searchProject(rm);
		List<User> users = SocioData.getSocioData().getUsers(actual);
		String cad = "Users to the project " + actual.getName();
		for (User u : users) {
			cad += ">" + u.userInfo() + "\n";
		}
		throw new SendMessageExc(cad);

	}

	@Override
	public String getName() {
		return "USERS_PROJECT";
	}

	@Override
	public String getDesc() {
		return "Send all users in a project.";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
