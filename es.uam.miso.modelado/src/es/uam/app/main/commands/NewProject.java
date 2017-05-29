package es.uam.app.main.commands;


import es.uam.app.main.exceptions.MessageException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.projects.Project;

public class NewProject extends MainCommand{

	public NewProject() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws MessageException {
		if (rm.getText() == null) {
			return;
		}
		if (rm.getText().equals("") || rm.getText().equals(" ")) {
			return;
		}
		String nameProject = validProjectName(rm.getText());
		Project.createProject(nameProject, rm);
		throw new MessageException("Excellent! Now there is a new project with the name " + nameProject);
		
	}

}
