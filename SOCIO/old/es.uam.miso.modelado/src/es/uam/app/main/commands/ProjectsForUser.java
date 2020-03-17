package es.uam.app.main.commands;

import java.util.List;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class ProjectsForUser extends MainCommand implements DataFormat {


	public ProjectsForUser() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
		List<Project> list = SocioData.getSocioData().getProjects(rm.getUser());
		String cad=this.printOwnProject(rm.getUser(), list);

		throw new SendMessageExc(cad);
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
