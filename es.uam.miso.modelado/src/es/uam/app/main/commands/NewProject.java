package es.uam.app.main.commands;



import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.LocalProjects;

import es.uam.app.projects.LocalProjects.ProjectType;
import socioProjects.Visibility;

public class NewProject extends MainCommand{

	public NewProject() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws Exception {
		if (rm.getProjectName() == null) {
			return;
		}
		if (rm.getProjectName().equals("") || rm.getProjectName().equals(" ")) {
			return;
		}
		String nameProject = validProjectName(rm.getProjectName());
		LocalProjects p=LocalProjects.getProject(nameProject);
		if (p!=null){
			throw new SendMessageExc("A project with the name "+nameProject+" already exists");
		}
		Visibility c;
		if (rm.hasText()){
			c=Visibility.valueOf(rm.getText());
		}else{
			c=Visibility.PUBLIC;
		}
		LocalProjects.createProject(nameProject, rm, ProjectType.METAMODEL, c, rm.getUser());
		throw new SendMessageExc("Excellent! Now there is a new "+ c.name().toLowerCase()+" project with the name " + nameProject);
		
	}

}
