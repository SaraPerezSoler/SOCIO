package com.socio.client.telegram.states.impl;

import org.json.JSONObject;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class RecommenderConversation implements ConversationalState{
	private static RecommenderConversation RECOMMENDER =new RecommenderConversation();

	public static RecommenderConversation getState() {
		return RECOMMENDER;
	}
	private RecommenderConversation() {
		
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		text = State.removeFirstCommand(text);
		
		JSONObject object= State.SOCIO().recommend(chat.getProject(), text);
		chat.sendMessage(object.toString(), false);
		
		return Chat.getDefaultState();
	}



}
