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

public class Remove implements CommandState {

	private static Remove REMOVE = new Remove();

	public static Remove getState() {
		return REMOVE;
	}

	private Remove() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {

		if (!chat.hasProject()) {
			throw new NotProjectException();
		}
		File file = State.SOCIO().edit(chat.getProject(), State.getUser(message.getFrom()), message.getText(), "",
				new Date(message.getDate()), message.getMessageId().toString());
		chat.sendPhoto(file);
		JSONObject elements = State.SOCIO().elemets(chat.getProject());
		List<String> optionsList = new ArrayList<>();
		if (elements.names() != null) {
			for (int i = 0; i < elements.names().length(); i++) {
				String className = elements.names().getString(i);
				optionsList.add("C: " + className);

				JSONObject classObject = elements.getJSONObject(className);
				if (classObject.has("features")) {
					JSONObject features = classObject.getJSONObject("features");
					if (features.names() != null) {
						for (int j = 0; j < features.names().length(); j++) {
							String featreName = className + "." + features.names().getString(j);
							optionsList.add("F: " + featreName);
						}
					}
				}
			}
		}

		String[] options = new String[optionsList.size()];
		options = optionsList.toArray(options);

		chat.sendMessageWithKeyboard("Which element do you want remove?", message.getMessageId(), true, options);
		return RemoveConversation.getState(optionsList);
	}

	@Override
	public String getCommand() {
		return "remove";
	}

	@Override
	public String getDescription() {
		return "remove elements in the model";
	}

}
