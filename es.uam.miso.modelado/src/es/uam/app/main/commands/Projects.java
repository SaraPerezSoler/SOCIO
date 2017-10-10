package es.uam.app.main.commands;

import java.util.List;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class Projects extends MainCommand implements DataFormat {


	public Projects() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
		List<Project> projects = SocioData.getSocioData().getProjects();
		String list=this.printProject(projects);
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
