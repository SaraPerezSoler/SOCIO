package com.socio.client.telegram.states.impl;

import java.util.List;

import org.json.JSONObject;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class RecommenderConversation implements ConversationalState {
	private List<String> elements;

	public static RecommenderConversation getState(List<String> elementList) {
		return new RecommenderConversation(elementList);
	}

	private RecommenderConversation(List<String> elementList) {
		this.elements = elementList;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		text = State.removeFirstCommand(text);
		JSONObject recomendation;
		User user = State.getUser(message.getFrom());
		if (text.equals(Recommender.ALL)) {
			recomendation = new JSONObject();
			for (String element : elements) {
				
				JSONObject obj = State.SOCIO().recommend(chat.getProject(), element, user);
				for (int i = 0; i < obj.names().length(); i++) {
					recomendation.put(obj.names().getString(i), obj.getJSONObject(obj.names().getString(i)));
				}
			}
		} else {

			recomendation = State.SOCIO().recommend(chat.getProject(), text, user);
		}
		RecommenderAddElement rae = RecommenderAddElement.getState(recomendation);
		rae.sendFirstMessage(chat, null);
		chat.recommender = rae;

//		chat.sendMessageWithKeyboard("This is are your recommendations", message.getMessageId(), false, options);
//		chat.sendMessage("This is are your recommendations: \n"+elements.toString(), message.getMessageId(), false);

		return Chat.getDefaultState();
	}

}
