package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class Reload extends RootCommands {

	public Reload() {
	}

	@Override
	public void exe(Msg rm) throws SendMessageExc, Exception {
	
			SocioData.getSocioData().loadProjects();
	}

	@Override
	public String getName() {
		return "RELOAD";
	}

	@Override
	public String getDesc() {
		return "reload all the app, only the user root can do this";
	}

	@Override
	public String getNeeds() {
		return "";
	}

}
