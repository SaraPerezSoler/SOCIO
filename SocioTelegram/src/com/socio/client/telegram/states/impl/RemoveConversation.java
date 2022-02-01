package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class RemoveConversation implements ConversationalState {

	private List<String> optionsList = new ArrayList<>();
	private List<String> classes = new ArrayList<>();
	private List<String> features = new ArrayList<>();
	private List<String> unknown = new ArrayList<>();
	private static final String END = "End";

	public static RemoveConversation getState(List<String> options) {
		return new RemoveConversation(options);
	}

	private RemoveConversation(List<String> options) {
		this.optionsList.add(END);
		this.optionsList.addAll(options);
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		if (text.equals(END)) {
			File file = State.SOCIO().delete(chat.getProject(), State.getUser(message.getFrom()), message.getText(), new Date(),
					getMessageId(message), classes, features, unknown);
			chat.sendPhoto(file, message.getMessageId());
			return Chat.getDefaultState();
		} else if (text.startsWith("C: ")) {
			classes.add(text.replace("C: ", ""));
		} else if (text.startsWith("F: ")) {
			features.add(text.replace("F: ", ""));
		} else {
			unknown.add(text);
		}
		optionsList.remove(text);
		String [] options = new String [optionsList.size()];
		options = optionsList.toArray(options);
		chat.sendMessageWithKeyboard("You can select an other element to remove or finish:", message.getMessageId(), true, options);
		return this;
	}

}
