package es.uam.app.channels.telegram;

import java.util.List;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.message.SendMessageExc;

public class Talk extends TelegramCommand {
	private static final String TALK_MSG = "Talk, the bot listens.";

	public Talk(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "talk";
	}

	@Override
	public String getDescription() {
		return "start a conversation with the bot";
	}

	@Override
	public void commandAction(Update update) {
		

		String project = this.getProject(update.getMessage().getChatId());
		if (project == null || project.equals("")) {
			SendMessageExc sent = new SendMessageExc(STANDARD_ERROR_MSG);
			tChannel.sendMessage(-1, update.getMessage().getChatId(), sent);
		} else {
			
			String text= update.getMessage().getText();
			String[] split = text.split(" ");

			if (split.length == 1) {
				this.addUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());
				
				String usersName=this.sendTalk(update.getMessage().getChatId());
				SendMessageExc sent = new SendMessageExc(usersName + TALK_MSG);
				tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(), sent);
				
				this.setStandardState(update.getMessage().getChatId());
			} else {
				String text2 = text.replace(split[0], "");
				this.setStandardState(update.getMessage().getChatId());
				tChannel.write(update,"", project, text2);

			}
		}
	}

	private String sendTalk(Long chatId) {
		List<String> users= this.getAllUserTalk(chatId);
		if (users != null) {
			if (!users.isEmpty()) {
				String usersName = "";
				for (int i = 0; i < users.size(); i++) {
					usersName += "@" + users.get(i) + " ";
				}
				return usersName;
			}
		}
		return "";
		
	}
	
	
}
