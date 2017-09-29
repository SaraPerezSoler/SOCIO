package es.uam.app.channels.telegramCommands;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.message.SendHistoryMsg;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class History extends TelegramCommand {

	private final String EXIT = "Exit from " + this.getCommand();
	public final String BACK = "\u2b05\ufe0f" + " Back";

	private final String OPTIONS_MSG = "Do you want see Statistics or get the messages from the project?";
	private final String[] OPTIONS = new String[] { "\ud83d\udcb9 Statistics", "\ud83d\udcac Get messages" };

	private Map<Long, Boolean> start_state = new HashMap<Long, Boolean>();

	private HistoryOption option;

	// private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	//
	// private Date fist;
	// private Date second;
	// private boolean newerFirst = true;

	public History(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "history";
	}

	@Override
	public String getDescription() {
		return "show a project's history";
	}

	@Override
	public void commandAction(Update update) {
		String project = this.getProject(update.getMessage().getChatId());
		option=null;
		if (project == null || project.equals("")) {
			this.setStandardState(update.getMessage().getChatId());
			SendMessageExc sent = new SendMessageExc(STANDARD_ERROR_MSG);
			tChannel.sendMessage(-1, update.getMessage().getChatId(), sent);

		} else {
			this.setState(update.getMessage().getChatId());
			start_state.put(update.getMessage().getChatId(), true);
			SendMessageExc sMessage = new SendMessageExc(OPTIONS_MSG);
			String[][] optionsKeydoard = new String[][] { { OPTIONS[0] }, { OPTIONS[1] }, { BACK } };
			tChannel.sendMessageWithKeyBoar(update.getMessage().getMessageId(), update.getMessage().getChatId(),
					sMessage, optionsKeydoard);
		}

	}

	@Override
	public void modellingAnswer(long chatId, int msgId, Msg rMessageCommand, SendMessageExc sMessage) {
		if (sMessage instanceof SendHistoryMsg && sMessage.getMessage().equals("")) {
			String split[] = ((SendHistoryMsg) sMessage).toString().split("\n");
			if (split.length >= 30) {
				FileWriter fileWrite = null;
				try {
					File file = new File("history.txt");
					fileWrite = new FileWriter(file);
					fileWrite.write(((SendHistoryMsg) sMessage).toString());
					fileWrite.close();
					sMessage.setText("Your log: ");
					sMessage.setDocument(file);
					tChannel.sendMessage(msgId, chatId, sMessage);
				} catch (Exception ex) {
				}
			} else {
				sMessage.setText(((SendHistoryMsg) sMessage).toString());
				tChannel.sendMessage(msgId, chatId, sMessage);
			}
			this.setStandardState(chatId);
		} else {
			super.modellingAnswer(chatId, msgId, rMessageCommand, sMessage);
		}

	}

	@Override
	public void userAnswerText(Update update) {
		String text = update.getMessage().getText();
		if (start_state.get(update.getMessage().getChatId())) {
			start_state.put(update.getMessage().getChatId(), false);
			if (text.equals(OPTIONS[0])) {
				option = Statistics.getHistoryStatistics(this);
			} else if (text.equals(OPTIONS[1])) {
				option = HistoryMsg.getHistoryMsg(this);
			} else {
				exit(update);
				return;
			}
			option.start(update);
		} else {
			if (option != null) {
				option.userAnswerText(update);
			}else{
				exit(update);
			}
		}
	}

	public void exit(Update update) {
		this.setStandardState(update.getMessage().getChatId());
		SendMessageExc sent = new SendMessageExc(EXIT);
		tChannel.sendMessage(update.getMessage().getMessageId(), update.getMessage().getChatId(), sent);
	}

}
