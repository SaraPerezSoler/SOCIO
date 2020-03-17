package com.socio.client.telegram.states.impl.management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.EndConsensus;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class EndVote implements ConversationalState{

	private EndConsensus end;
	private static final String SUCCESSFULLY = "*Consensus* has been reached";
	
	public static EndVote getState(EndConsensus end) {
		return new EndVote(end);
	}
	
	public EndVote(EndConsensus end) {
		super();
		this.end = end;
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		
		String measure = "The consensus measure is "+end.getMeasure()*100+"% and the required is "+end.getRequired()*100+"%.";
		boolean noVoted = false;
		for (User u: end.getNotVoted()) {
			if (u.getId() == chat.getId() && u.getChannel().equals(TelegramControl.getTelegramControl().getChannelName())) {
				noVoted = true;
			}
		}

		String distance;
		if (!noVoted) {
			boolean close=false;
			for (User u: end.getClose().keySet()) {
				if (u.getId() == chat.getId() && u.getChannel().equals(TelegramControl.getTelegramControl().getChannelName())) {
					close = end.getClose().get(u);
				}
			}
			if (close) {
				distance = "You are *close* to the collective preference.";
			}else {
				distance = "You are *far* to the collective preference.";
			}
		}else {
			distance = "You have not engaged in this poll.";
		}
		
		String preference = "The collective preference is:\n";
		List<Integer> pos = new ArrayList<>(end.getPreference().keySet());
		 Collections.sort(pos);
		for (int i : pos) {
			preference += i+". "+end.getPreference().get(i)+"\n";
		}
		//Se ha alcanzado un consenso
		if (end.getMeasure() >= end.getRequired()) {
			//Todos los usuarios han votado
			if (end.getNotVoted().isEmpty()) {
				chat.sendMessage(SUCCESSFULLY+"!\n"+ measure+"\n" + distance +"\n"+preference , true);
				
			}else {
				chat.sendMessage(SUCCESSFULLY+" but not all the users have been voted. \n"+ measure+"\n" + distance +"\n"+preference , true);
			}
		}else {
			chat.sendMessage("The vote is over but no consensus has been reached.\n"+ measure+"\n" + distance +"\n"+preference , true);
		}
		if (end.getBranchs()!=null) {
			chat.sendMessage("The project has be merged.", false);
			chat.sendPhoto(end.getBranchs());
		}
		return Chat.getDefaultState();
	}

}
