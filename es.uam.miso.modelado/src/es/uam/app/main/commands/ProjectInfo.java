package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class ProjectInfo extends MainCommand {

	public ProjectInfo() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual= searchProject(rm);
		String cad =SocioData.getSocioData().getProjectData(actual);
		throw new SendMessageExc(cad);

	}

	@Override
	public String getName() {
		return "PROJECT_INFO";
	}

	@Override
	public String getDesc() {
		return "Get all info of a project";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
