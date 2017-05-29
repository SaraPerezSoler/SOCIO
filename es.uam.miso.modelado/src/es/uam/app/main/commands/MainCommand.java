package es.uam.app.main.commands;

import es.uam.app.main.ValidText;
import es.uam.app.main.exceptions.MessageException;
import es.uam.app.message.ReceivedMessage;

public abstract class MainCommand {
	private static final char[] validProjectCharacteres = { '_' };
	
	public abstract void execute (ReceivedMessage rm) throws MessageException, Exception;

	protected String validProjectName (String text){
		return ValidText.validText(text, validProjectCharacteres);
	}
}
