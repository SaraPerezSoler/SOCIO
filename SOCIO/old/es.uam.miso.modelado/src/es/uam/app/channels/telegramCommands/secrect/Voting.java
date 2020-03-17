package es.uam.app.channels.telegramCommands.secrect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.channels.telegramCommands.TelegramControl;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class Voting extends SecretCommand {

	private Map<Long, String> projectName = new HashMap<Long, String>();
	private Map<Long, String> branchGroup = new HashMap<Long, String>();
	private Map<Long, List<String>> users = new HashMap<>();
	private Map<Long, Integer> privateState = new HashMap<Long, Integer>();
	private static final String END = "end";
	private static final String[] OPTIONS = { "Select one", "Vote in a branch group", "Exit" };
	private static final int START = 0;
	private static final int SELECT_TYPE_SELECTION = 1;
	private static final int SELECT_ONE = 2;
	private static final int VOTING = 3;

	public Voting(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "selectbranchfor";
	}

	@Override
	public void commandAction(Update update) {
		String text = update.getMessage().getText();
		String[] split = text.split(" ");
		long chatId = update.getMessage().getChatId();

		if (split.length != 2) {
			this.setStandardState(chatId);
			SendMessageExc sMessage = new SendMessageExc(
					"The command needs the project to select a branch. Go to /projectmanagement.");
			this.tChannel.sendMessage(update.getMessage().getMessageId(), chatId, sMessage);
		} else {
			this.setState(update.getMessage().getChatId());
			this.privateState.put(chatId, START);
			projectName.put(chatId, split[1]);
			tChannel.write(update, CommandList.GET_OPEN_BRANCH_GROUP, split[1], null, null);
		}

	}

	@Override
	public void modellingAnswer(long chatId, int msgId, Msg rMessage, SendMessageExc sMessage) {
		if (privateState.get(chatId) == START){
			String text=sMessage.getText();
			String[][] options=super.groupOptions(text);
			if (options.length==0){
				SendMessageExc sMsg= new SendMessageExc("This project doesn't have branchs");
				this.setStandardState(chatId);
				tChannel.sendMessage(msgId, chatId, sMsg);
			}else{
				sMessage.setText(super.getProjectsFormat(text)+"\n What group?");
				tChannel.sendMessageWithKeyBoar(msgId, chatId, sMessage, options);
			}
		}else if (privateState.get(chatId)==SELECT_ONE){
			String[][] options=super.getProjects(sMessage.getText());
			sMessage.setText(super.getProjectsFormat(sMessage.getText())+"\n What project do you choose?");
			tChannel.sendMessageWithKeyBoar(msgId, chatId, sMessage, options);
		}else if (privateState.get(chatId)==VOTING){
			
			super.modellingAnswer(chatId, msgId, rMessage, sMessage);
			this.setStandardState(chatId);
			
		}
	}

	@Override
	public void userAnswerText(Update update) {
		long chatId = update.getMessage().getChatId();
		String text=update.getMessage().getText();
		if (privateState.get(chatId) == START) {
			branchGroup.put(chatId, update.getMessage().getText());
			SendMessageExc sMsg= new SendMessageExc("How do you want to select the branchs?");
			tChannel.sendMessageWithKeyBoar(update.getMessage().getMessageId(), chatId, sMsg, new String[][]{{OPTIONS[0]},{OPTIONS[1]},{OPTIONS[2]}});
			this.privateState.put(chatId, SELECT_TYPE_SELECTION);
			
		} else if (privateState.get(chatId) == SELECT_TYPE_SELECTION) {
			if (text.equals(OPTIONS[0])){//Select One
				tChannel.write(update, CommandList.START_DECISION, projectName.get(chatId), null, branchGroup.get(chatId));
				this.privateState.put(chatId, SELECT_ONE);
			}else if (text.equals(OPTIONS[1])){//Voting
				this.privateState.put(chatId, VOTING);
				askForUsers(update);
			}else{
				super.exit(update);
			}
		} else if (privateState.get(chatId) == SELECT_ONE) {
			tChannel.write(update, CommandList.MAKE_DECISION, projectName.get(chatId), "", branchGroup.get(chatId)+"-"+text);
			this.setStandardState(chatId);
		}else{
			if (update.getMessage().getText().equals(END)) {
				if (users.get(chatId) == null || users.get(chatId).size() < 2) {
					SendMessageExc sMessage = new SendMessageExc("You must has at least two users");
					tChannel.sendMessage(update.getMessage().getMessageId(), chatId, sMessage);
					askForUsers(update);
				} else {
					String usersList="";
					for (String u: users.get(chatId)){
						if (!usersList.equals("")){
							usersList+="-";
						}
						usersList+=u;
					}
					tChannel.write(update, CommandList.START_CONSENSUS, projectName.get(chatId), usersList, branchGroup.get(chatId));
					tChannel.write(update, CommandList.START_C_VOTING, projectName.get(chatId), "", branchGroup.get(chatId));
				}
			} else {
				List<String> thisusers = users.get(chatId);
				if (thisusers == null) {
					thisusers = new ArrayList<String>();
				}
				thisusers.add(update.getMessage().getText());
				users.put(chatId, thisusers);
				askForUsers(update);
			}
		}
	}

	private void askForUsers(Update update) {
		long chatId = update.getMessage().getChatId();
		int msgId=update.getMessage().getMessageId();
		SendMessageExc sMessage = new SendMessageExc(
				"Who should vote? Enter user (channel/nick), or press enter if finished.");
		tChannel.sendMessageWithKeyBoar(msgId, chatId, sMessage, new String[][] { { END } });
	}
}
