package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.LocalProjects;

public class Statistics extends MainCommand {

	public static final int USER_MSG = 0;
	public static final int USER_ACTION = 2;
	public static final int ABS_USER_MSG = 3;
	public static final int ABS_USER_ACTION = 4;
	public static final int ACTION = 5;
	public static final int RATE = 6;

	private int option;

	public Statistics(int option) {
		this.option = option;
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {

		String nameProject = validProjectName(rm.getProjectName());
		LocalProjects actual = LocalProjects.getProject(nameProject);
		if (actual == null) {
			throw new ProjectNotFoundException(nameProject);
		}
		
		if (!(rm.getUser().canRead(actual))){
			throw new NotAccessException("");
		}
		
		if (option == USER_MSG) {
			if (!rm.hasText()) {
				File jpg = actual.getStatisticsUserMsg();
				throw new SendMessageExc(jpg);
			} else {
				File jpg = actual.getStatisticsUserMsg(rm.getText());
				throw new SendMessageExc(jpg);
			}
		} else if (option == USER_ACTION) {
			if (!rm.hasText()) {
				File jpg = actual.getStatisticsUserAction();
				throw new SendMessageExc(jpg);
			} else {
				File jpg = actual.getStatisticsUserAction(rm.getText());
				throw new SendMessageExc(jpg);
			}
		} else if (option == ABS_USER_MSG) {
			File jpg = actual.getStatisticsUserMsgAbs();
			throw new SendMessageExc(jpg);
		} else if (option == ABS_USER_ACTION) {
			File jpg = actual.getStatisticsUserActionAbs();
			throw new SendMessageExc(jpg);
		} else if (option == ACTION) {
			File jpg = actual.getStatisticsActions();
			throw new SendMessageExc(jpg);
		} else {
			File jpg= actual.percentOfAuthorship();
			throw new SendMessageExc(jpg);
		}

	}

}
