package es.uam.app.channels.telegramCommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;

import es.uam.app.channels.CommandList;
import es.uam.app.channels.telegramCommands.secrect.SecretCommand;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public abstract class TCommand {

	public static List<TelegramCommand> commands = new ArrayList<TelegramCommand>();
	public static List<SecretCommand> secretCommands = new ArrayList<SecretCommand>();

	protected static TCommand standardState;
	public static TCommand helpState;

	private final String EXIT = "Exit from " + this.getCommand();

	private static Map<Long, String> chatProject = new HashMap<Long, String>();
	private static Map<Long, TCommand> chatState = new HashMap<Long, TCommand>();
	private static Map<Long, List<String>> usersTalk = new HashMap<Long, List<String>>();

	protected static final String STANDARD_ERROR_MSG = "You don't have a selected project. You can choose one with /setProject.";

	protected TelegramControl tChannel;

	public TCommand(TelegramControl tChannel) {
		super();
		this.tChannel = tChannel;
	}

	public static TCommand getCommand(String text) {
		String nameBot = TelegramControl.NAME_BOT.toLowerCase();
		for (TelegramCommand tc : commands) {
			if (text.startsWith("/" + tc.getCommand() + " ")
					|| text.startsWith("/" + tc.getCommand() + "@" + nameBot + " ")) {
				return tc;
			}
			if (text.equals("/" + tc.getCommand()) || text.equals("/" + tc.getCommand() + "@" + nameBot)) {
				return tc;
			}
		}

		for (SecretCommand tc : secretCommands) {
			if (text.startsWith("/" + tc.getCommand() + " ")
					|| text.startsWith("/" + tc.getCommand() + "@" + nameBot + " ")) {
				return tc;
			}
			if (text.equals("/" + tc.getCommand()) || text.equals("/" + tc.getCommand() + "@" + nameBot)) {
				return tc;
			}
		}
		return null;
	}

	public abstract String getCommand();

	public abstract void commandAction(Update update);

	protected void addUserTalk(Long chatId, User user) {
		List<String> users = usersTalk.get(chatId);
		if (users == null) {
			users = new ArrayList<>();
			usersTalk.put(chatId, users);
		}

		if (user.getUserName() != null) {
			if (!users.contains(user.getUserName())) {
				users.add(user.getUserName());
			}
		}
	}

	protected void removerUserTalk(Long chatId, User user) {
		List<String> users = usersTalk.get(chatId);
		if (users == null) {
			users = new ArrayList<>();
			usersTalk.put(chatId, users);
		} else {
			users.remove(user.getUserName());
		}
	}

	protected void removerAllUserTalk(Long chatId) {
		List<String> users = usersTalk.get(chatId);
		if (users == null) {
			users = new ArrayList<>();
			usersTalk.put(chatId, users);
		} else {
			users.clear();
		}
	}

	protected List<String> getAllUserTalk(Long chatId) {
		List<String> users = usersTalk.get(chatId);
		return users;
	}

	protected void setStandardState(Long chatId) {
		chatState.put(chatId, standardState);
	}

	public void setState(Long chatId) {
		chatState.put(chatId, this);
	}

	public static TCommand getState(Long chatId) {
		return chatState.get(chatId);
	}

	protected void setProject(Long chatId, String projName) {
		chatProject.put(chatId, projName);
	}

	protected String getProject(Long chatId) {
		return chatProject.get(chatId);
	}

	public void userAnswerText(Update update) {

		removerUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());

		String project = chatProject.get(update.getMessage().getChatId());
		if (project == null || project.equals("")) {
			SendMessageExc sent = new SendMessageExc(STANDARD_ERROR_MSG);
			tChannel.sendMessage(update.getMessage().getMessageId(), update.getMessage().getChatId(), sent);
		} else {
			this.setStandardState(update.getMessage().getChatId());
			String text = update.getMessage().getText().toLowerCase();
			tChannel.write(update, CommandList.BASE_CASE, project, null, text);
		}
	}

	public void userAnswer(Update update) {

	}

	public void modellingAnswer(long chatId, int msgId, Msg rMessage, SendMessageExc sMessage) {

		this.setStandardState(chatId);
		sMessage.setText(getProjectsFormat(sMessage.getText()));
		tChannel.sendMessage(msgId, chatId, sMessage);
	}
	
	public TelegramControl gettChannel() {
		return tChannel;
	}

	public void exit(Update update) {
		this.setStandardState(update.getMessage().getChatId());
		SendMessageExc sent = new SendMessageExc(EXIT);
		tChannel.sendMessage(update.getMessage().getMessageId(), update.getMessage().getChatId(), sent);
	}

	protected String[][] getProjects(String text) {

		String[] projectsInfo = text.split(">");
		String[][] projects;
		int numProjecst = projectsInfo.length - 1;

		if ((numProjecst) % 2 == 0) {
			projects = new String[numProjecst / 2][];
		} else {
			projects = new String[(numProjecst / 2) + 1][];
		}

		for (int i = 0; i < projectsInfo.length - 1; i++) {
			String p = projectsInfo[i + 1].split("\n")[0];
			if (i % 2 == 0) {
				if (i != numProjecst - 1) {
					projects[i / 2] = new String[2];
				} else {
					projects[i / 2] = new String[1];
				}
			}
			projects[i / 2][i % 2] = p;
		}
		return projects;
	}

	protected String getProjectsFormat(String text) {
		if (text == null) {
			return "";
		}
		String[] allText = text.split("\n");
		String finalText = "";
		for (String line : allText) {
			if (line.replace("\t", "").startsWith("Project:")) {
				line = "*" + line + "*";
			} else if (line.replace("\t", "").startsWith(">")) {
				line = "*" + line + "*";
			} else if (line.replace("\t ", "").startsWith("Branch of")) {
				line = line.split("Branch of ")[0] + "Branch of _" + line.split("Branch of ")[1] + "_";
			} else if (line.replace("\t", "").startsWith("+")) {
				line = "      + _" + line.replace("\t", "").replace("+", "") + "_";
			}
			line = line.replace("\t", "   ");
			finalText += line + "\n";
		}
		return finalText;
	}

	public boolean projectInfoIsBranch(String text) {
		String[] allText = text.split("\n");
		for (String line : allText) {
			if (line.replace("\t ", "").startsWith("Branch of")) {
				return true;
			}
		}
		return false;
	}

	public boolean projectInfoHasBranch(String text) {
		String[] allText = text.split("\n");
		for (String line : allText) {
			if (line.replace("\t", "").startsWith("- Open branchs:")) {
				return true;
			}
		}
		return false;
	}
	
	protected String[][] groupOptions(String text){
		String [] lineas=text.split("\n");
		List<String> groups= new ArrayList<String>();
		for (String l: lineas){
			if (l.startsWith("-")){
				groups.add(l.replace("-", "").replace(" ", ""));
			}
		}
		String[][] ret=new String[groups.size()][1];
		
		for (int i=0; i<groups.size(); i++){
			ret[i][0]=groups.get(i);
		}
		return ret;
	}

	public static TCommand getStandardState() {
		return standardState;
	}
}
