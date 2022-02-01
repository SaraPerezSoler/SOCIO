package com.socio.client.telegram.states.impl.history;

import java.io.File;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class HistoryStatistics implements ConversationalState {

	private static final HistoryStatistics HISTORY_STATISTICS = new HistoryStatistics();

	public static HistoryStatistics getState() {
		return HISTORY_STATISTICS;
	}

	private static final String[] OPTIONS = History.STATISTICS_OPTIONS;
	static final String WHO = "Who? (channel/nick)";

	private static final String QUESTION = "Do you want see the statistics sorted by date?";
	static final String YES_OPTION = "Yes";
	static final String NO_OPTION = "No";

	private HistoryStatistics() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		File file = null;

		if (text.equals(OPTIONS[0])) { // Messages from one user
			chat.sendMessageAndForceReply(WHO, message.getMessageId(), false);
			return HistoryStatisticsGetUser.getState(false);
		} else if (text.equals(OPTIONS[1])) { // Messages from all users
			chat.sendMessageWithKeyboard(QUESTION, message.getMessageId(), false,
					new String[] { YES_OPTION, NO_OPTION });
			return HistoryStatisticsGetAbs.getState(false);
		} else if (text.equals(OPTIONS[2])) { // Actions from one user
			chat.sendMessageAndForceReply(WHO, message.getMessageId(), false);
			return HistoryStatisticsGetUser.getState(true);
		} else if (text.equals(OPTIONS[3])) { // Actions from all user
			chat.sendMessageWithKeyboard(QUESTION, message.getMessageId(), false,
					new String[] { YES_OPTION, NO_OPTION });
			return HistoryStatisticsGetAbs.getState(true);
		} else if (text.equals(OPTIONS[4])) { // All actions
			file = State.SOCIO().statisticsAllActions(chat.getProject(), State.getUser(message.getFrom()));
		} else if (text.equals(OPTIONS[5])) { // Percent of authorship
			file = State.SOCIO().statisticsAthorship(chat.getProject(), State.getUser(message.getFrom()));
		} else { // back
			return History.exit(chat, message);
		}

		chat.sendPhoto(file, message.getMessageId());
		return Chat.getDefaultState();
	}

}
