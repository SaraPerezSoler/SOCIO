package com.socio.client.telegram.states.impl;

import java.io.File;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class GetConversational implements ConversationalState {

	private static GetConversational GET = new GetConversational();

	public static GetConversational getState() {
		return GET;
	}

	private GetConversational() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		text = State.removeFirstCommand(text);
		File file;
		if (text.isEmpty() && chat.hasProject()) {
			file= SOCIO.get(chat.getProject(), State.getUser(message.getFrom()));
		} else {
			Project project = TelegramControl.projects.get(text);
			
			if (project == null) {
				file = SOCIO.get(text, State.getUser(message.getFrom()));
			} else {
				file = SOCIO.get(project, State.getUser(message.getFrom()));
			}
		}
		chat.sendDocument(file, message.getMessageId());
		return Chat.getDefaultState();
	}

}
