package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.Date;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.NotProjectException;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Recommender  implements CommandState{
	private static Recommender RECOMMENDER =new Recommender();

	public static Recommender getState() {
		return RECOMMENDER;
	}
	
	private Recommender() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		
		String text = State.removeFirstCommand(message.getText());
		if (!chat.hasProject()) {
			throw new NotProjectException();
		}
		if (text == null || text.isEmpty()) {
			File file = State.SOCIO().edit(chat.getProject(), State.getUser(message.getFrom()), message.getText(), "",
					new Date(message.getDate()), message.getMessageId().toString());
			
			chat.sendPhoto(file, message.getMessageId());
			chat.sendMessageAndForceReply("Choose a class for the recomendation", message.getMessageId(), false);
			return RecommenderConversation.getState();
		}
		return RecommenderConversation.getState().runAndNext(chat, message);
		
	}

	@Override
	public String getCommand() {
		return "recommender";
	}

	@Override
	public String getDescription() {
		return "recommends you attributes and superclasses for a specific class";
	}

}
