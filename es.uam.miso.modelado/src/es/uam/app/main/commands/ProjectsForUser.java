package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class ProjectsForUser extends MainCommand {


	public ProjectsForUser() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
		String list = SocioData.getSocioData().getProjectForUser(rm.getUser());
		throw new SendMessageExc(list);
	}

	@Override
	public String getName() {
		return "PROJECTS_FOR_USER";
	}

	@Override
	public String getDesc() {
		return "sends all the project that the user who sends the msg has";
	}

	@Override
	public String getNeeds() {
		return "";
	}

}
