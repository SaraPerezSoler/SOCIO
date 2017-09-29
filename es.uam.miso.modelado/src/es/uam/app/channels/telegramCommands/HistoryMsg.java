package es.uam.app.channels.telegramCommands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.message.SendMessageExc;

public class HistoryMsg extends HistoryOption {

	private static HistoryMsg historyMsg = null;

	protected enum HistoryState {
		START, ACTION, USER, USER2, ELEMENT, DATE

	};

	protected Map<Long, HistoryState> historyState = new HashMap<Long, HistoryState>();
	protected final String[] OPTIONS = new String[] { "Element", "User", "Action", "Date", "All" };
	protected final String[] ACTIONS = new String[] { "Create", "Update", "Remove" };
	protected final String[] ORDER_OPTION = new String[] { "Increasing order", "Descending order" };

	private Date start = null;
	private Date end = null;

	public static HistoryMsg getHistoryMsg(History history) {
		if (historyMsg == null) {
			historyMsg = new HistoryMsg(history);
		}
		return historyMsg;
	}

	private HistoryMsg(History history) {
		super(history);
	}

	@Override
	public void userAnswerText(Update update) {
		String project = history.getProject(update.getMessage().getChatId());
		if (historyState.get(update.getMessage().getChatId()) == HistoryState.START) {
			startState(update);
		} else if (historyState.get(update.getMessage().getChatId()) == HistoryState.ACTION) {
			String text = update.getMessage().getText();
			if (!text.equals(ACTIONS[0]) && !text.equals(ACTIONS[1]) && !text.equals(ACTIONS[2])) {
				history.commandAction(update);
				return;
			}
			history.tChannel.write(update, CommandList.HISTORY_ACTIONS, project,null, text);

		} else if (historyState.get(update.getMessage().getChatId()) == HistoryState.USER) {
			String text = update.getMessage().getText();
			history.tChannel.write(update, CommandList.HISTORY_USER, project, text, null);

		} else if (historyState.get(update.getMessage().getChatId()) == HistoryState.ELEMENT) {
			String text = update.getMessage().getText();
			history.tChannel.write(update, CommandList.HISTORY_ELEMENT, project, null, text);

		} else if (historyState.get(update.getMessage().getChatId()) == HistoryState.DATE) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			if (start == null) {
				String[] split = update.getMessage().getText().split("-");
				try {
					if (split.length >= 2) {
						start = formatter.parse(split[0]);
						end = formatter.parse(split[1]);
					} else {
						start = formatter.parse(split[0]);
					}
					SendMessageExc sMessage = new SendMessageExc("Increasing or descending order?");
					String[][] options = new String[][] { { ORDER_OPTION[0] }, { ORDER_OPTION[1] }, { BACK } };
					history.tChannel.sendMessageWithKeyBoar(update.getMessage().getMessageId(),
							update.getMessage().getChatId(), sMessage, options);
				} catch (ParseException e) {
					this.start(update);
				}
			} else {
				String text = update.getMessage().getText();
				if (text.equals(ORDER_OPTION[0])) {
					String msg;
					if (end==null){
						msg=formatter.format(start)+"-ASCENDING";
					}else{
						msg=formatter.format(start)+"-"+formatter.format(end)+"-ASCENDING";
					}
					history.tChannel.write(update, CommandList.HISTORY_ALL, project, null, msg);
					
				} else if (text.equals(ORDER_OPTION[1])) {
					String msg;
					if (end==null){
						msg=formatter.format(start)+"-DESCENDING";
					}else{
						msg=formatter.format(start)+"-"+formatter.format(end)+"-DESCENDING";
					}
					history.tChannel.write(update, CommandList.HISTORY_ALL, project, null, msg);
				} else {
					this.start(update);
				}
			}
		}
	}

	private void startState(Update update) {
		String text = update.getMessage().getText();
		history.setState(update.getMessage().getChatId());

		if (text.equals(OPTIONS[0])) {// "Element",

			SendMessageExc sMessage = new SendMessageExc("name?");
			historyState.put(update.getMessage().getChatId(), HistoryState.ELEMENT);
			history.tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(),
					sMessage);

		} else if (text.equals(OPTIONS[1])) {// "User",

			historyState.put(update.getMessage().getChatId(), HistoryState.USER);
			SendMessageExc sMessage = new SendMessageExc(WHO);
			history.tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(),
					sMessage);

		} else if (text.equals(OPTIONS[2])) {// "Action",

			SendMessageExc sMessage = new SendMessageExc("What action?");
			String[][] actionsKeyboard = new String[][] { { ACTIONS[0] }, { ACTIONS[1] }, { ACTIONS[2] }, { BACK } };
			historyState.put(update.getMessage().getChatId(), HistoryState.ACTION);
			history.tChannel.sendMessageWithKeyBoar(update.getMessage().getMessageId(), update.getMessage().getChatId(),
					sMessage, actionsKeyboard);
		} else if (text.equals(OPTIONS[3])) {// "Date",
			sendWhenQuestion(update);

		} else if (text.equals(OPTIONS[4])) {// "All"
			String project = history.getProject(update.getMessage().getChatId());
			history.tChannel.write(update, CommandList.HISTORY_ALL, project,null,null );
		} else {
			history.commandAction(update);
		}

	}

	private void sendWhenQuestion(Update update) {

		start = null;
		end = null;
		historyState.put(update.getMessage().getChatId(), HistoryState.DATE);
		SendMessageExc sMessage = new SendMessageExc(
				"When? You can send a date (dd/mm/yy) or a range of dates (dd/mm/yy-dd/mm/yy)");
		history.tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(),
				sMessage);
	}

	public void start(Update update) {
		SendMessageExc sMessage = new SendMessageExc("Filter by:");
		String[][] options = new String[][] { { OPTIONS[0], OPTIONS[1] }, { OPTIONS[2], OPTIONS[3] },
				{ OPTIONS[4], BACK }, };
		history.setState(update.getMessage().getChatId());
		historyState.put(update.getMessage().getChatId(), HistoryState.START);

		history.gettChannel().sendMessageWithKeyBoar(update.getMessage().getMessageId(),
				update.getMessage().getChatId(), sMessage, options);
	}

}
