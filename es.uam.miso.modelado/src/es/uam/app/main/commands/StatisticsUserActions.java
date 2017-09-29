package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public class StatisticsUserActions extends MainCommand {

	public StatisticsUserActions() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {

		Project actual = searchProject(rm);

		if (!(rm.getUser().canRead(actual))) {
			throw new NotAccessException("");
		}

		if (!rm.hasUserToSearch()) {
			File jpg = actual.getStatisticsUserAction();
			throw new SendMessageExc(jpg);
		} else {
			User u=searchUser(rm.getUserToSearch());
			
			File jpg = actual.getStatisticsUserAction(u);
			throw new SendMessageExc(jpg);
		}

	}

	@Override
	public String getName() {
		return "STA_USER_ACTIONS";
	}

	@Override
	public String getDesc() {
		return "";
	}

	@Override
	public String getNeeds() {
		return project()+", optional:"+userToSearch();
	}

}
