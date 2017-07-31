package es.uam.app.channels.telegramCommands;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.main.Main;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;

public class SetProject extends TelegramCommand {

	private static final String SET_PROJECT_MSG1 = "Choose the project to this chat.";
	private static final String SET_PROJECT_MSG2 = "Project selected";
	
	public SetProject(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "setproject";
	}

	@Override
	public String getDescription() {
		return "select a project to the chat";
	}

	@Override
	public void commandAction(Update update) {
		String text= update.getMessage().getText();
		
		this.removerAllUserTalk(update.getMessage().getChatId());
		this.setState(update.getMessage().getChatId());
		
		String[] split = text.split(" ");
		// Si el comando no tiene argumentos
		if (split.length == 1) {
			tChannel.write(update, Main.MainCommandEnum.PROJECTS.getName(), "", "");
		} else {
			String text2 = text.replace(split[0], "");
			text2 = text2.replace(" ", "");
			tChannel.write(update,"", text2, "");
		}

	}
	
	@Override
	public void modellingAnswer(long chatId, int msgId, ReceivedMessage rMessageCommand, SendMessageExc sMessage) {
		if (rMessageCommand.getCommand().equals(Main.MainCommandEnum.PROJECTS.getName())) {
			sMessage.setText(SET_PROJECT_MSG1);
			tChannel.sendMessageAndWait(msgId, chatId, sMessage);
		} else {
			if (sMessage.getText() != null && sMessage.getText().startsWith(ProjectNotFoundException.PROJECT_NOT_FOUND)) {
				tChannel.sendMessage(msgId, chatId, sMessage);
				sMessage.setText(SET_PROJECT_MSG1);
				tChannel.sendMessageAndWait(msgId, chatId, sMessage);
			} else {
				sMessage.setText(SET_PROJECT_MSG2);
				this.setProject(chatId, rMessageCommand.getProjectName());
				this.setStandardState(chatId);
				tChannel.sendMessage(msgId, chatId, sMessage);
			}
		}
	}
	@Override
	public void userAnswerText(Update update) {
		this.setState(update.getMessage().getChatId());
		tChannel.write(update, "", update.getMessage().getText(), "");
	};

}
