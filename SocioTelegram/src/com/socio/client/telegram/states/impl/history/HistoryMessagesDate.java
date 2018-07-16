package com.socio.client.telegram.states.impl.history;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class HistoryMessagesDate implements ConversationalState {
	private SimpleDateFormat formatter = Chat.FORMATTER;

	private static HistoryMessagesDate HISTORY = new HistoryMessagesDate();

	public static HistoryMessagesDate getState() {
		return HISTORY;
	}

	private HistoryMessagesDate() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		String[] split = text.split("-");
		Date start;
		Date end;

		if (split.length < 1) {
			start = null;
			end = null;
		} else {

			try {
				start = formatter.parse(split[0]);
			} catch (ParseException e) {
				start = null;
			}
			if (split.length > 1) {
				try {
					end = formatter.parse(split[1]);
				} catch (ParseException e) {
					end = null;
				}
			} else {
				end=null;
			}
		}

		List<com.socio.client.beans.Message> messages = SOCIO.history(chat.getProject(),
				State.getUser(message.getFrom()), start, end);
		chat.sendHistory(messages, message.getMessageId());
		return Chat.getDefaultState();
	}

}
