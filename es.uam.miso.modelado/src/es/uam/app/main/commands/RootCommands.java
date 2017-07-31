package es.uam.app.main.commands;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.message.User;

public abstract class RootCommands extends MainCommand {
	
	public RootCommands() {
		
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
		User user=rm.getUser();
		if (user.isRoot()){
			exe(rm);
		}else{
			throw new NotAccessException("Only the root can do it.");
		}

	}
	
	public abstract void exe(ReceivedMessage rm)throws SendMessageExc, Exception;
	
	

}
