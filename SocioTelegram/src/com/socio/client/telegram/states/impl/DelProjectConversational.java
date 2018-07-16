package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class DelProjectConversational implements ConversationalState {
	private static DelProjectConversational DEL_PROJECT = new DelProjectConversational();

	public static DelProjectConversational getState() {
		return DEL_PROJECT;
	}

	private DelProjectConversational() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = State.removeFirstCommand(message.getText());
		Project project = TelegramControl.projects.get(text);
		String response;
		if (project == null) {
			response = SOCIO.removeProject(text, State.getUser(message.getFrom()));
		} else {
			response = SOCIO.removeProject(project, State.getUser(message.getFrom()));
		}
		chat.sendMessage(response, message.getMessageId(), false);
		return Chat.getDefaultState();
	}

}
