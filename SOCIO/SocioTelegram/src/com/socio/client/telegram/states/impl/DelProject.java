package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class DelProject implements CommandState {
	private static DelProject DEL_PROJECT = new DelProject();

	public static DelProject getState() {
		return DEL_PROJECT;
	}

	private DelProject() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = State.removeFirstCommand(message.getText());
		if (text == null || text.isEmpty()) {
			chat.askProject(message.getMessageId(), Chat.OWNER_LEVEL, State.getUser(message.getFrom()));
			return DelProjectConversational.getState();
		}
		return DelProjectConversational.getState().runAndNext(chat, message);
	}

	@Override
	public String getDescription() {
		return "delete a project";
	}

	@Override
	public String getCommand() {
		return "delproject";
	}

}
