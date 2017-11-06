package es.uam.app.channels.telegramCommands;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

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
			tChannel.write(update, CommandList.PROJECT_USER_ACCESS,null,null,null);
		} else {
			String text2 = text.replace(split[0], "");
			text2 = text2.replace(" ", "");
			tChannel.write(update,CommandList.PROJECT_INFO, text2, null,null);
		}
	}
	
	@Override
	public void modellingAnswer(long chatId, int msgId, Msg rMessageCommand, SendMessageExc sMessage) {
		if (rMessageCommand.getCommand().equals(CommandList.PROJECT_USER_ACCESS)) {
			String text=sMessage.getText();
			sMessage.setText(getProjectsFormat(sMessage.getMessage())+"\n\n"+SET_PROJECT_MSG1);
			String[][] projects=super.getProjects(text);
			tChannel.sendMessageWithKeyBoar(msgId, chatId, sMessage, projects);
		} else {
			if (sMessage.getText() != null && sMessage.getText().startsWith(ProjectNotFoundException.PROJECT_NOT_FOUND)) {
				tChannel.sendMessage(msgId, chatId, sMessage);
				sMessage.setText(sMessage.getMessage()+"\n\n"+SET_PROJECT_MSG1);
				tChannel.sendMessageAndWait(msgId, chatId, sMessage);
			} else {
				String projectName=sMessage.getText().split("\n")[0].replace("Project: ", "");
				sMessage.setText(getProjectsFormat(sMessage.getMessage())+"\n\n"+SET_PROJECT_MSG2);
				this.setProject(chatId, projectName);
				this.setStandardState(chatId);
				tChannel.sendMessage(msgId, chatId, sMessage);
			}
		}
	}
	@Override
	public void userAnswerText(Update update) {
		this.setState(update.getMessage().getChatId());
		tChannel.write(update, CommandList.PROJECT_INFO, update.getMessage().getText(),null, null);
	};

}
