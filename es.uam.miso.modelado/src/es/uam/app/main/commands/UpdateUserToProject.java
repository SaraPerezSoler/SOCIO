package es.uam.app.main.commands;


import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Access;
import socioProjects.Project;
import socioProjects.User;

public class UpdateUserToProject extends MainCommand {

	public UpdateUserToProject() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {

		Project actual= searchProject(rm);
		if (rm.getUser().isAdmin(actual)){
			User u=searchUser(rm.getUserToSearch());
			if (u!=null){
				if (u.canEdit(actual)){
					SocioData.getSocioData().addUserToProject(actual, u, Access.READ);
					throw new SendMessageExc("The user "+u.getNick()+" has been modified to the project:\n\t >"+SocioData.getSocioData().getProjectData(actual));
				}else if (u.canRead(actual)){
					SocioData.getSocioData().addUserToProject(actual, u, Access.EDIT);
					throw new SendMessageExc("The user "+u.getNick()+" has been modified to the project:\n\t >"+SocioData.getSocioData().getProjectData(actual));
				}
			}
			
				throw new SendMessageExc("The user "+rm.getUserToSearch()+" is not in the project");
				
		}else{
			throw new NotAccessException("Only the project admin can modify a user to the project");
		}
	}

	@Override
	public String getName() {
		return "UPDATE_USER_TO_PROJECT";
	}

	@Override
	public String getDesc() {
		return "Modify a user access to one project, if the user only can read then he can edit and if he can edit then he only can read";
	}

	@Override
	public String getNeeds() {
		return project() + ", " + userToSearch();
	}

}
