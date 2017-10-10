package es.uam.app.main.commands;

import java.util.List;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.Visibility;

public class ProjectsForVisibility extends MainCommand implements DataFormat{


	public ProjectsForVisibility() {

	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
		Visibility v=Visibility.get(rm.getText());
		
		List<Project> list = SocioData.getSocioData().getProjectsForVisibility(v);
		
		throw new SendMessageExc(this.printVisibilityProjects(v, list));
	}

	@Override
	public String getName() {
		return "PROJECTS_VISIBILITY";
	}

	@Override
	public String getDesc() {
		return "sends all projects with some visibility";
	}

	@Override
	public String getNeeds() {
		return "the visibility (Public, Private, Protected) in the field text";
	}

}
