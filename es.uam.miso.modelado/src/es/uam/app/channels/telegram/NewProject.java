package es.uam.app.channels.telegram;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.main.Main;
import es.uam.app.message.SendMessageExc;

public class NewProject extends TelegramCommand {
	
	private static final String NEW_PROJECT_MSG = "Alright, a new project. How are we going to call it? "
			+ "Please choose a name for the project.";

	public NewProject(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "newproject";
	}

	@Override
	public String getDescription() {
		return "create and set a new project";
	}

	@Override
	public void commandAction(Update update) {
		
		
		String text = update.getMessage().getText().toLowerCase();
		// Si hay users esperando el talk se limpia la lista.s
		this.removerAllUserTalk(update.getMessage().getChatId());

		String[] split = text.split(" ");
		// Si el comando no tiene argumentos
		if (split.length == 1) {
			this.setState(update.getMessage().getChatId());
			SendMessageExc sent = new SendMessageExc(NEW_PROJECT_MSG);
			tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(),
					sent);

		} else {
			this.setStandardState(update.getMessage().getChatId());
			String text2 = text.replace(split[0] + " ", "");
			tChannel.write(update, Main.MainCommandEnum.NEW_PROJECT.getName(), text2);
			this.setProject(update.getMessage().getChatId(), text2);
		}

	}
	
	@Override
	public void userAnswer(Update update) {
		this.setStandardState(update.getMessage().getChatId());
		tChannel.write(update, Main.MainCommandEnum.NEW_PROJECT.getName(), update.getMessage().getText());
		this.setProject(update.getMessage().getChatId(), update.getMessage().getText());
	}

}
