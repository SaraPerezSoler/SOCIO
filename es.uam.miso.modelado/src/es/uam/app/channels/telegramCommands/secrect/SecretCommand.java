package es.uam.app.channels.telegramCommands.secrect;

import java.lang.reflect.Constructor;

import es.uam.app.channels.telegramCommands.TCommand;
import es.uam.app.channels.telegramCommands.TelegramControl;

public abstract class SecretCommand extends TCommand{

	public static VoteAction voteCommand;
	
	public SecretCommand(TelegramControl tChannel) {
		super(tChannel);
	}

	public static void regiterTelegramSecretCommand(Class<? extends SecretCommand> command,
			TelegramControl tChannel) throws Exception {

		
		Constructor<? extends SecretCommand> commandConstructor = command
				.getConstructor(new Class[] { TelegramControl.class });
		if (commandConstructor != null) {
			SecretCommand commandInstance = commandConstructor.newInstance(tChannel);
			secretCommands.add(commandInstance);
			if (commandInstance instanceof VoteAction){
				voteCommand=(VoteAction)commandInstance;
			}
		}
		
	}
}
