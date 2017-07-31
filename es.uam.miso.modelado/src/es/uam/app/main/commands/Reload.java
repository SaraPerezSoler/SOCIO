package es.uam.app.main.commands;

import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.LocalProjects;

public class Reload extends RootCommands {

	public Reload() {
	}

	@Override
	public void exe(ReceivedMessage rm) throws SendMessageExc, Exception {
	
			LocalProjects.reloadProjects();
	}

}
