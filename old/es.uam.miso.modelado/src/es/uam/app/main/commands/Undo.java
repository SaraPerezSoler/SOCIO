package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class Undo extends MainCommand {

	public Undo() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		
		Project actual = searchProject(rm);
		if (!(rm.getUser().canEdit(actual))){
			throw new NotAccessException("");
		}
		File png = SocioData.getSocioData().undo(actual, rm);
		throw new SendMessageExc(rm.getText(), png);		
	}

	@Override
	public String getName() {
		return "UNDO";
	}

	@Override
	public String getDesc() {
		return "undo the last msg";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
