package es.uam.app.channels.telegramCommands;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class DelProject extends TelegramCommand {

	private static final String DEL_MSG="What project do you want delete?";
	public DelProject(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getDescription() {
		return "delete a project";
	}

	@Override
	public String getCommand() {
		return "delproject";
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
			this.tChannel.write(update, CommandList.PROJECTS_FOR_USER, null, null, null);
		} else {
			this.setStandardState(update.getMessage().getChatId());
			String text2 = text.replace(split[0] + " ", "");
			tChannel.write(update, CommandList.REMOVE_PROJECT, text2,null, null);
			this.setProject(update.getMessage().getChatId(), "");
			
		}

	}
	
	@Override
	public void modellingAnswer(long chatId, int msgId, Msg rMessageCommand, SendMessageExc sMessage) {

		if (sMessage.getText() != null && sMessage.getText().startsWith(ProjectNotFoundException.PROJECT_NOT_FOUND)) {
			this.setStandardState(chatId);
			tChannel.sendMessageAndWait(msgId, chatId, sMessage);
		} else {
			this.setState(chatId);
			sMessage.setText(sMessage.getText()+"\n\n"+DEL_MSG);
			tChannel.sendMessageAndWait(msgId, chatId, sMessage);
		}
	}
	
	@Override
	public void userAnswerText(Update update) {
		this.setStandardState(update.getMessage().getChatId());
		tChannel.write(update, CommandList.REMOVE_PROJECT, update.getMessage().getText(), null, null);
	}

}
