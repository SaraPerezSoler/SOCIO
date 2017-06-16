package es.uam.app.main.commands;


import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.Project;
import es.uam.app.projects.Project.ProjectType;

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
		Project p=Project.getProject(nameProject);
		if (p!=null){
			throw new SendMessageExc("A project with the name "+nameProject+" already exists");
		}
		Project.createProject(nameProject, rm, ProjectType.METAMODEL);
		throw new SendMessageExc("Excellent! Now there is a new project with the name " + nameProject);
		
	}

}
