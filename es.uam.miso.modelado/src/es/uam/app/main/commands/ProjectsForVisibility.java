package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Visibility;

public class ProjectsForVisibility extends MainCommand {


	public ProjectsForVisibility() {

	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
		Visibility v=Visibility.get(rm.getText());
		
		String list = SocioData.getSocioData().getProjectsForVisibility(v);
		throw new SendMessageExc(list);
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
