package com.socio.client.telegram.states.impl.history;

import java.io.File;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.NotProjectException;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class History implements CommandState, ConversationalState {

	static final String BACK = "\u2b05\ufe0f" + " Exit";

	private static final String OPTIONS_MSG = "Do you want see Statistics or get the messages from the project?";
	private static final String[] OPTIONS = new String[] { "\ud83d\udcb9 Statistics", "\ud83d\udcac Get messages",
			"Project history", BACK };
	
	private static final String STATISTICS_TEXT = "Which kind?";
	static final String[] STATISTICS_OPTIONS = { "Messages from one user", "Messages from all users",
			"Actions from one user", "Actions from all user", "All actions", "Percent of authorship", BACK };
	private static final String MESSAGE_TEXT = "Filter by:";
	static final String[] MESSAGE_OPTIONS = new String[] { "Element", "User", "Action", "Date", "All", BACK };
	
	
	private static History HISTORY = new History();

	public static History getState() {
		return HISTORY;
	}

	private History() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		if (!chat.hasProject()) {
			throw new NotProjectException();
		}
		if (State.hasFirstCommand(text)) {
			chat.sendMessageWithKeyboard(OPTIONS_MSG, message.getMessageId(), false, OPTIONS);
			return this;
		}else {
			if (text.equals(OPTIONS[0])) {//Statistics
				chat.sendMessageWithKeyboard(STATISTICS_TEXT, message.getMessageId(), false, STATISTICS_OPTIONS);
				return HistoryStatistics.getState();
			}else if (text.equals(OPTIONS[1])) {//Messages
				chat.sendMessageWithKeyboard(MESSAGE_TEXT, message.getMessageId(), false, MESSAGE_OPTIONS);
				return HistoryMessages.getState();
			}else if (text.equals(OPTIONS[2])) {//ProjectHistory
				File file=State.SOCIO().projectHistory(chat.getProject(), State.getUser(message.getFrom()));
				chat.sendPhoto(file, message.getMessageId());
				return Chat.getDefaultState();
			}else {//back
				return exit(chat, message);
			}
		}

	}
	
	static State exit(Chat chat, Message message) throws TelegramApiException {
		chat.sendMessage("Leaving the history menu.", message.getMessageId(), false);
		return Chat.getDefaultState();
	}
	@Override
	public String getCommand() {
		return "history";
	}

	@Override
	public String getDescription() {
		return "show a project's history";
	}
}
