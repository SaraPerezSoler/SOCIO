package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class SetProject implements CommandState {
	private static SetProject SET_PROJECT = new SetProject();

	public static SetProject getState() {
		return SET_PROJECT;
	}

	private SetProject() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = State.removeFirstCommand(message.getText());
		if (text == null || text.isEmpty()) {
			chat.askProject(message.getMessageId(), Chat.READ_LEVEL, State.getUser(message.getFrom()));
			return SetProjectConversation.getState();
		}
		return SetProjectConversation.getState().runAndNext(chat, message);
	}

	@Override
	public String getCommand() {
		return "setproject";
	}

	@Override
	public String getDescription() {
		return "select a project to the chat";
	}

}
