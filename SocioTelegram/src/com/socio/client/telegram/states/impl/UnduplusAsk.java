package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.Date;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class UnduplusAsk implements ConversationalState {

	private static UnduplusAsk UNDO_PLUS_ASK = new UnduplusAsk();
	private static final String UNDOPLUS_MSG = "How many undos do you want?";
	private static final String UNDOPLUS_MSG1 = "The value must be a number.";

	public static UnduplusAsk getState() {
		return UNDO_PLUS_ASK;
	}

	public UnduplusAsk() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = State.removeFirstCommand(message.getText());
		if (text == null || text.isEmpty()) {
			chat.sendMessageAndForceReply(UNDOPLUS_MSG, message.getMessageId(), false);
			return this;
		} else {
			try {
				int i = Integer.parseInt(text.replaceAll(" ", ""));
				File file = null;
				for (int j = 0; j < i; j++) {
					file = State.SOCIO().undo(chat.getProject(), State.getUser(message.getFrom()), message.getText(),
							message.getText(), new Date(), getMessageId(message));
				}
				if (file == null) {
					chat.sendMessageAndForceReply("There is not change", message.getMessageId(), false);
				}
				chat.sendPhoto(file, message.getMessageId());
				return Chat.getDefaultState();
			} catch (NumberFormatException e) {
				chat.sendMessageAndForceReply(UNDOPLUS_MSG1+UNDOPLUS_MSG, message.getMessageId(), false);
				return this;
			}
		}
	}
}
