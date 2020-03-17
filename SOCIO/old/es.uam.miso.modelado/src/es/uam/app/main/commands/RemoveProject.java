package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class RemoveProject extends MainCommand {

	public RemoveProject() {
	}	

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual = searchProject(rm);
		
		if (!(rm.getUser().isAdmin(actual) || rm.getUser().isRoot())){
			throw new NotAccessException("");
		}
			
		SocioData.getSocioData().removeProject(actual);
		throw new SendMessageExc("The project "+ actual.getName()+" has been deleted.");
		
	}

	@Override
	public String getName() {
		return "REMOVE_PROJECT";
	}

	@Override
	public String getDesc() {
		return "remove a project, only the owner can do this";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
