package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
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

	public static final String ALL = "All the model";
	
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
			JSONObject elements = State.SOCIO().elemets(chat.getProject());
			List<String> elementList = new ArrayList<>();
			if (elements.names() != null) {
				for (int i = 0; i < elements.names().length(); i++) {
					String className = elements.names().getString(i);
					elementList.add(className);
				}
			}
			
			List<String> optionList = new ArrayList<>();
			optionList.add(ALL);
			optionList.addAll(elementList);
			
			String[] options = new String[optionList.size()];
			options = optionList.toArray(options);
			chat.sendMessageWithKeyboard("Choose a class for the recomendation", message.getMessageId(), false, options);
			return RecommenderConversation.getState(elementList);
		}
		return RecommenderConversation.getState(new ArrayList<>()).runAndNext(chat, message);
		
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
