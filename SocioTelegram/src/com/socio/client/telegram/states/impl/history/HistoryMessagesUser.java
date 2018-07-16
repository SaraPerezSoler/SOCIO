package com.socio.client.telegram.states.impl.history;

import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class HistoryMessagesUser implements ConversationalState {
	private static HistoryMessagesUser HISTORY = new HistoryMessagesUser();

	public static HistoryMessagesUser getState() {
		return HISTORY;
	}

	private HistoryMessagesUser() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		User userToSearch=State.textToUser(text);

		List<com.socio.client.beans.Message> messages = SOCIO.history(chat.getProject(),
				State.getUser(message.getFrom()), userToSearch);
		chat.sendHistory(messages, message.getMessageId());
		return Chat.getDefaultState();
	}

}
