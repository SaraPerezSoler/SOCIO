package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class Projects extends MainCommand {


	public Projects() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
		String list = SocioData.getSocioData().getAllProjects();
		throw new SendMessageExc(list);
	}

	@Override
	public String getName() {
		return "PROJECTS";
	}

	@Override
	public String getDesc() {
		return "sends a list with all the projects";
	}

	@Override
	public String getNeeds() {
		return "";
	}

}
