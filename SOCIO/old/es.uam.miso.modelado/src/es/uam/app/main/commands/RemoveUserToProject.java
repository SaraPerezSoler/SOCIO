package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public class RemoveUserToProject extends MainCommand {

	public RemoveUserToProject() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual= searchProject(rm);
		if (rm.getUser().isAdmin(actual)){
			User u=searchUser(rm.getUserToSearch());
			if (u!=null){
				if (u.canEdit(actual)||u.canRead(actual)){
					SocioData.getSocioData().removeUserToProject(actual, u);
					throw new SendMessageExc("The user "+u.getNick()+" has been removed to the project:\n\t >"+SocioData.getSocioData().getProjectData(actual));
				}
			}
			
				throw new SendMessageExc("The user "+rm.getUserToSearch()+" is not in the project");
				
		}else{
			throw new NotAccessException("Only the project admin can remove a user to the project");
		}
	}

	@Override
	public String getName() {
		return "REMOVE_USER_TO_PROJECT";
	}

	@Override
	public String getDesc() {
		return "Remove a user access to one project";
	}

	@Override
	public String getNeeds() {
		return project() + ", " + userToSearch();
	}

}
