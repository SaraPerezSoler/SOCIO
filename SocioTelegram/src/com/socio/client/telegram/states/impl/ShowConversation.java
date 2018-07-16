package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.Date;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ShowConversation implements ConversationalState {
	private static ShowConversation SHOW = new ShowConversation();

	public static ShowConversation getState() {
		return SHOW;
	}

	private ShowConversation() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		text = State.removeFirstCommand(text);
		File file;
		if (text.isEmpty() && chat.hasProject()) {
			file = SOCIO.edit(chat.getProject(), State.getUser(message.getFrom()), message.getText(), "",
					new Date(message.getDate()), message.getMessageId().toString());
		} else {
			Project project = TelegramControl.projects.get(text);
			if (project == null) {
				file= SOCIO.edit(text, State.getUser(message.getFrom()), message.getText(), "",
					new Date(message.getDate()), message.getMessageId().toString());
			}else {
				file= SOCIO.edit(project, State.getUser(message.getFrom()), message.getText(), "",
						new Date(message.getDate()), message.getMessageId().toString());
			}
		}
		chat.sendPhoto(file, message.getMessageId());
		return Chat.getDefaultState();
	}

}
