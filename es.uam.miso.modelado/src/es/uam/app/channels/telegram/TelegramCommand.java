package es.uam.app.channels.telegram;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import es.uam.app.message.SentMessage;

public abstract class TelegramCommand {

	public static List<TelegramCommand> commands = new ArrayList<TelegramCommand>();
	private static TelegramCommand standardState;
	public static TelegramCommand helpState;
	
	private static final Class<? extends TelegramCommand> standardStateClass= Start.class;
	public static final Class<? extends TelegramCommand> helpStateClass= Help.class;
	
	private static Map<Long, String> chatProject= new HashMap<Long, String>();
	private static Map<Long, TelegramCommand> chatState= new HashMap<Long, TelegramCommand>();
	private static Map<Long, List<String>> usersTalk= new HashMap<Long, List<String>>();

	protected static final String STANDARD_ERROR_MSG = "You don't have a selected project. You can choose one with /setProject or start the sentence with / and the project's name.";

	protected TelegramControl tChannel;
	

	public TelegramCommand(TelegramControl tChannel) {
		super();
		this.tChannel = tChannel;
	}

	public static void regiterTelegramCommand(Class<? extends TelegramCommand> command,
			TelegramControl tChannel) throws Exception {

		Constructor<? extends TelegramCommand> commandConstructor = command
				.getConstructor(new Class[] { TelegramControl.class });
		if (commandConstructor != null) {
			TelegramCommand commandInstance = commandConstructor.newInstance(tChannel);
			commands.add(commandInstance);
			
			if (command.equals(standardStateClass)){
				standardState = commandInstance;
			}
			
			if (command.equals(helpStateClass)){
				helpState = commandInstance;
			}
		}
		
	}
	public static TelegramCommand getCommand(String text){
		String nameBot=TelegramControl.NAME_BOT.toLowerCase();
		for (TelegramCommand tc: commands){
			if (text.startsWith("/"+tc.getCommand()+" ")|| text.startsWith("/"+tc.getCommand()+"@"+nameBot+" ")){
				return tc;
			}
			if (text.equals("/"+tc.getCommand())|| text.equals("/"+tc.getCommand()+"@"+nameBot)){
				return tc;
			}
		}
		return null;
	}
	
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

	protected void setState(Long chatId) {
		chatState.put(chatId, this);
	}
	
	public static TelegramCommand getState(Long chatId) {
		return chatState.get(chatId);
	}
	
	protected void setProject(Long chatId, String projName) {
		chatProject.put(chatId, projName);
	}
	protected String getProject(Long chatId) {
		return chatProject.get(chatId);
	}

	public abstract String getCommand();

	public abstract String getDescription();

	public abstract void commandAction(Update update);

	public void userAnswer(Update update) {

		removerUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());

		String project = chatProject.get(update.getMessage().getChatId());
		if (project == null || project.equals("")) {
			SentMessage sent = new SentMessage();
			sent.setText(STANDARD_ERROR_MSG);
			tChannel.sendMessage(update.getMessage().getMessageId(), update.getMessage().getChatId(), sent);
		} else {
			this.setStandardState(update.getMessage().getChatId());
			String text = update.getMessage().getText().toLowerCase();
			tChannel.write(update, project, text);
		}
	}

	public void modellingAnswer(long chatId, int msgId, String rMessageCommand, SentMessage sMessage) {
		
		this.setStandardState(chatId);
		tChannel.sendMessage(msgId, chatId, sMessage);
	}

}
