package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.Project;

public class Projects extends MainCommand {

	private static final String PROJECTS = "Projects";

	public Projects() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc {
		File list = Project.getProjectList();
		throw new SendMessageExc(PROJECTS, list);
	}

}
