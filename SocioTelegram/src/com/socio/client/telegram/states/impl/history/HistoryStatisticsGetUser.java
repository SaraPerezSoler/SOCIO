package com.socio.client.telegram.states.impl.history;

import java.io.File;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class HistoryStatisticsGetUser implements ConversationalState {

	private boolean isAction;

	public static HistoryStatisticsGetUser getState(boolean isAction) {
		return new HistoryStatisticsGetUser(isAction);
	}

	private HistoryStatisticsGetUser(boolean isAction) {
		this.isAction = isAction;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		String[] split = text.split("/");
		User userToSearch;
		if (split.length == 1) {
			userToSearch = new User(TelegramControl.getTelegramControl().getChannelName(), split[0]);
		} else {
			userToSearch = new User(split[0], split[1]);
		}
		File file = SOCIO.statistics(chat.getProject(), State.getUser(message.getFrom()), isAction, userToSearch);
		chat.sendPhoto(file, message.getMessageId());
		return Chat.getDefaultState();
	}

}
