package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Show implements CommandState {
	private static Show SHOW = new Show();

	public static Show getState() {
		return SHOW;
	}

	private Show() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = State.removeFirstCommand(message.getText());
		if ((text == null || text.isEmpty()) && !chat.hasProject()) {
			chat.askProject(message.getMessageId(), Chat.READ_LEVEL, State.getUser(message.getFrom()));
			return ShowConversation.getState();
		}else {
			return ShowConversation.getState().runAndNext(chat, message);
		}
	}

	@Override
	public String getCommand() {
		return "show";
	}

	@Override
	public String getDescription() {
		return "show a project";
	}

}
