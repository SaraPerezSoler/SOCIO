package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.MessageException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.projects.Project;

public class Help extends MainCommand{
	
	public static final int TEXT=0;
	public static final int PICTURE=1;
	
	private int option;
	
	public Help(int option) {
		this.option=option;
	}

	@Override
	public void execute(ReceivedMessage rm) throws MessageException, Exception {
		if (option==TEXT){
			String help=Project.getHelp();
			throw new MessageException(help);
		}else{
			File help=Project.getHelpFile();
			throw new MessageException(help);
		}
		
		
	}

	

}
