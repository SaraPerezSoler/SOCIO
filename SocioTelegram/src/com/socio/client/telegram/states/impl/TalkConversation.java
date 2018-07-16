package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.Date;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.NotProjectException;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class TalkConversation implements ConversationalState {

	private static TalkConversation TALK_CONVERSATION = null;

	public static TalkConversation getState() {
		if (TALK_CONVERSATION == null) {
			TALK_CONVERSATION = new TalkConversation();
		}
		return TALK_CONVERSATION;
	}

	private TalkConversation() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		text = State.removeFirstCommand(text);
		if (chat.hasProject()) {
			User user = State.getUser(message.getFrom());
			File response = SOCIO.edit(chat.getProject(), user, message.getText(), text, new Date(), getMessageId(message));
			chat.sendPhoto(response, message.getMessageId());
		} else {
			throw new NotProjectException();
		}
		return Chat.getDefaultState();
	}

}
