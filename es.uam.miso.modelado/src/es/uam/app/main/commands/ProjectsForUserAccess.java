package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class ProjectsForUserAccess extends MainCommand {


	public ProjectsForUserAccess() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
		String list = SocioData.getSocioData().getProjectsForUserPermision(rm.getUser());
		throw new SendMessageExc(list);
	}

	@Override
	public String getName() {
		return "PROJECT_USER_ACCESS";
	}

	@Override
	public String getDesc() {
		
		return "sends all the project that the user who sends the msg has some access";
	}

	@Override
	public String getNeeds() {
		return "";
	}

}
