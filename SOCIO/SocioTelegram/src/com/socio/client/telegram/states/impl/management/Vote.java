package com.socio.client.telegram.states.impl.management;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class Vote implements ConversationalState{

	private Project project;
	private String branchGroup;
	private Map<String, File> branchs;
	private List<String> branchOptions;
	private Map<Integer, String> preference = new HashMap<>();
	private int pos = 1;
	public static Vote getState(Project project, String branchGroup, Map<String, File> branchs) {
		return new Vote(project, branchGroup, branchs);
	}
	
	public Vote(Project project, String branchGroup,  Map<String, File> branchs) {
		super();
		this.project = project;
		this.branchs = branchs;
		this.branchGroup = branchGroup;
		this.branchOptions = new ArrayList<>(this.branchs.keySet());
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		if (message == null) {
			chat.sendMessage("A poll has started for the project: \n"+State.printProject(project), true);
			chat.sendMessage("You must to select your preferences. The options are: ", false);
			for (String k : branchs.keySet()) {
				chat.sendMessage(k, false);
				chat.sendPhoto(branchs.get(k));
			}
			askForOption(chat);
			return this;
		}else {
			String text = message.getText();
			if (!branchOptions.contains(text)) {
				chat.sendMessage("Select one option", message.getMessageId(), false);
				askForOption(chat);
				return this;
			}
			branchOptions.remove(text);
			preference.put(pos, text);
			pos++;
			if (branchOptions.size()>1) {
				askForOption(chat);
				return this;
			}
			if (branchOptions.size() == 1) {
				preference.put(pos, branchOptions.get(0));
			}
			//Enviar a SOCIO la votacion
			String ans = State.SOCIO().setPoll(project, State.getUser(message.getFrom()), branchGroup, preference);
			chat.sendMessage(ans, false);
			return Chat.getDefaultState();
		}
	}

	private void askForOption(Chat chat) throws TelegramApiException {
		String options [] = new String[branchOptions.size()];
		options = branchOptions.toArray(options);
		chat.sendMessageWithKeyboard("What do you want in "+getNumber(pos)+" place?", -1, false, options);
		
	}
	
	private String getNumber(int nRound){
		String number=nRound+"";
		if (nRound%10==1 && nRound!=11){
			number+="st";
		}else if (nRound%10==2 && nRound!=12){
			number+="nd";
		}else if (nRound%10==3&& nRound!=13){
			number+="rd";
		}else{
			number+="th";
		}
		return number;
	}
}
