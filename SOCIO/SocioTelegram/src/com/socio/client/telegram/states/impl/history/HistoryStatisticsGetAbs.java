package com.socio.client.telegram.states.impl.history;

import java.io.File;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class HistoryStatisticsGetAbs implements ConversationalState {

	private static final String YES_OPTION = HistoryStatistics.YES_OPTION;

	private boolean isAction;

	public static HistoryStatisticsGetAbs getState(boolean isAction) {
		return new HistoryStatisticsGetAbs(isAction);
	}

	private HistoryStatisticsGetAbs(boolean isAction) {
		this.isAction = isAction;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		File file;
		if (text.equals(YES_OPTION)) {
			file = State.SOCIO().statistics(chat.getProject(), State.getUser(message.getFrom()), isAction, false);
		} else {
			file = State.SOCIO().statistics(chat.getProject(), State.getUser(message.getFrom()), isAction, true);
		}
		
		chat.sendPhoto(file, message.getMessageId());
		return Chat.getDefaultState();
	}

}
