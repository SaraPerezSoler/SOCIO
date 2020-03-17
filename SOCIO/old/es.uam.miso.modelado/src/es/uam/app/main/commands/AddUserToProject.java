package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Access;
import socioProjects.Project;
import socioProjects.User;
import socioProjects.impl.SocioProjectsFactoryImpl;

public class AddUserToProject extends MainCommand {

	public AddUserToProject() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual = searchProject(rm);
		if (rm.getUser().isAdmin(actual)) {
			User u = searchUser(rm.getUserToSearch());
			if (u == null) {
				u=SocioProjectsFactoryImpl.eINSTANCE.createUser();
				String[] split=rm.getUserToSearch().split("/");
				if (split.length<2){
					u.setNick(split[0]);
					u.setChannel(rm.getUser().getChannel());
				}else{
					u.setChannel(split[0]);
					u.setNick(split[1]);
				}
				SocioData.getSocioData().addUser(u);
			}
			Access a = Access.EDIT;
			if (rm.hasText()) {
				Access aaux = Access.get(rm.getText());
				if (aaux != null) {
					a = aaux;
				}
			}

			SocioData.getSocioData().addUserToProject(actual, u, a);
			throw new SendMessageExc(
					"The user " + u.getNick() + " has been added to the project:\n\t >" + SocioData.getSocioData().getProjectData(actual));

		} else {
			throw new NotAccessException("Only the project admin can add a user to this project");
		}
	}

	@Override
	public String getName() {
		return "ADD_USER_TO_PROJECT";
	}

	@Override
	public String getDesc() {
		return "Add a user access to one project";
	}

	@Override
	public String getNeeds() {
		return project() + ", " + userToSearch() + ", and the user access (READ or EDIT) in the text field";
	}

}
