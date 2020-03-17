package com.socio.client.telegram.states.impl.history;

import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class HistoryMessagesElementAction implements ConversationalState {
	
	private boolean isAction;
	
	public static HistoryMessagesElementAction getState(boolean isAction) {
		return new HistoryMessagesElementAction(isAction);
	}

	private HistoryMessagesElementAction(boolean isAction) {
		this.isAction=isAction;
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {

		String text= message.getText();
		List<com.socio.client.beans.Message>messages = State.SOCIO().history(chat.getProject(), State.getUser(message.getFrom()), text, isAction);
		chat.sendHistory(messages, message.getMessageId());
		return Chat.getDefaultState();
	}

}
