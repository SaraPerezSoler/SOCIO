package es.uam.app.main.commands;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class Validate extends MainCommand {

	public Validate() {
	}
	
	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual=searchProject(rm);
		
		if (!(rm.getUser().canRead(actual))){
			throw new NotAccessException("");
		}
		String text = actual.validate();
		throw new SendMessageExc("Validate " + actual.getName() + ":\n\n" + text);
		
	}

	@Override
	public String getName() {
		return "VALIDATE";
	}

	@Override
	public String getDesc() {
		return "verifies that the meta-model is correct, reporting all errors.";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
