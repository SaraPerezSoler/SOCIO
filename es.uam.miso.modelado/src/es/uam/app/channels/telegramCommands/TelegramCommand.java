package es.uam.app.channels.telegramCommands;

import java.lang.reflect.Constructor;

public abstract class TelegramCommand extends TCommand {

	public TelegramCommand(TelegramControl tChannel) {
		super(tChannel);
	}

	private static final Class<? extends TelegramCommand> standardStateClass = Start.class;
	public static final Class<? extends TelegramCommand> helpStateClass = Help.class;

	public static void regiterTelegramCommand(Class<? extends TelegramCommand> command, TelegramControl tChannel)
			throws Exception {

		Constructor<? extends TelegramCommand> commandConstructor = command
				.getConstructor(new Class[] { TelegramControl.class });
		if (commandConstructor != null) {
			TelegramCommand commandInstance = commandConstructor.newInstance(tChannel);
			commands.add(commandInstance);

			if (command.equals(standardStateClass)) {
				standardState = commandInstance;
			}

			if (command.equals(helpStateClass)) {
				helpState = commandInstance;
			}
		}

	}

	public abstract String getDescription();






}
