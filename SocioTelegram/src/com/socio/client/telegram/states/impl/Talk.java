package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Talk implements CommandState {
	private static final String TALK_MSG = "Talk, the bot listens.";

	private static Talk TALK = null;

	public static Talk getState() {
		if (TALK == null) {
			TALK = new Talk();
		}
		return TALK;
	}

	private Talk() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		text = State.removeFirstCommand(text);
		if (text == null || text.isEmpty()) {
			chat.sendMessageAndForceReply(TALK_MSG, message.getMessageId(), false);
			return TalkConversation.getState();
		} else {
			return TalkConversation.getState().runAndNext(chat, message);
		}
	}

	@Override
	public String getCommand() {
		return "talk";
	}

	@Override
	public String getDescription() {
		return "start a conversation with the bot";
	}

}
