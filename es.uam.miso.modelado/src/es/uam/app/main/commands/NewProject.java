package es.uam.app.main.commands;


import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.Project;

public class NewProject extends MainCommand{

	public NewProject() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc {
		if (rm.getProjectName() == null) {
			return;
		}
		if (rm.getProjectName().equals("") || rm.getProjectName().equals(" ")) {
			return;
		}
		String nameProject = validProjectName(rm.getProjectName());
		Project.createProject(nameProject, rm);
		throw new SendMessageExc("Excellent! Now there is a new project with the name " + nameProject);
		
	}

}
