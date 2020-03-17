package com.socio.client.telegram.states.impl.history;

import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class HistoryMessages implements ConversationalState {
	
	private static final String ELEMENT_QUESTION="Which element?";
	private static final String ACTION_QUESTION="What action?";
	private static final String[] ACTIONS = new String[] { "Create", "Update", "Remove" };
	
	
	private static final String DATE_PATTERN=Chat.FORMATTER.toPattern();
	private static final String DATE_QUESTION="When? You can send a date ("+DATE_PATTERN+") or a range of dates ("+DATE_PATTERN+"-"+DATE_PATTERN+")";
	
	private static final String[] OPTIONS=History.MESSAGE_OPTIONS;
	
	
	private static HistoryMessages HISTORY = new HistoryMessages();

	public static HistoryMessages getState() {
		return HISTORY;
	}

	private HistoryMessages() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text=message.getText();
		if (text.equals(OPTIONS[0])) {//Element
			chat.sendMessageAndForceReply(ELEMENT_QUESTION, message.getMessageId(), false);
			return HistoryMessagesElementAction.getState(false);
		}else if (text.equals(OPTIONS[1])) {//User
			chat.askUser(message.getMessageId());
			return HistoryMessagesUser.getState();
		}else if (text.equals(OPTIONS[2])) {//Action
			chat.sendMessageWithKeyboard(ACTION_QUESTION, message.getMessageId(), false, ACTIONS);
			return HistoryMessagesElementAction.getState(true);
		}else if (text.equals(OPTIONS[3])) {//Date
			chat.sendMessageAndForceReply(DATE_QUESTION, message.getMessageId(), false);
			return HistoryMessagesDate.getState();
		}else if (text.equals(OPTIONS[4])) {//All
			List<com.socio.client.beans.Message> messages= State.SOCIO().history(chat.getProject(), State.getUser(message.getFrom()));
			chat.sendHistory(messages, message.getMessageId());
			return Chat.getDefaultState();
		}else { //back
			return History.exit(chat, message);
		}
	}

}
