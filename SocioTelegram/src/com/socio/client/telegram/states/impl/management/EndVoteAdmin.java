package com.socio.client.telegram.states.impl.management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.EndConsensus;
import com.socio.client.beans.Polling;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class EndVoteAdmin implements ConversationalState {

	private EndConsensus end;
	private static final String SUCCESSFULLY = "*Consensus* has been reached";
	private static final String[] OPTIONS = { "Revote", ProjectManager7SelectBranchOption.SELECT_BRANCH_OPTIONS[0] };

	public static EndVoteAdmin getState(EndConsensus end) {
		return new EndVoteAdmin(end);
	}

	public EndVoteAdmin(EndConsensus end) {
		super();
		this.end = end;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		if (message == null) {
			String measure = "The consensus measure is " + end.getMeasure() * 100 + "% and the required is "
					+ end.getRequired() * 100 + "%.";
			String usersNoVoted;
			if (end.getNotVoted().isEmpty()) {
				usersNoVoted = "Every user has voted";
			} else {
				usersNoVoted = "The users that has not voted are: \n";
				for (User u : end.getNotVoted()) {
					usersNoVoted += "> " + u.getChannel() + "/" + u.getNick() + "\n";
				}
			}

			String preference = "The collective preference is:\n";
			List<Integer> pos = new ArrayList<>(end.getPreference().keySet());
			Collections.sort(pos);
			for (int i : pos) {
				preference += i + ". " + end.getPreference().get(i) + "\n";
			}
			// Se ha alcanzado un consenso
			if (end.getMeasure() >= end.getRequired()) {
				// Todos los usuarios han votado
				if (end.getNotVoted().isEmpty()) {
					chat.sendMessage(SUCCESSFULLY + "!\n" + measure + "\n" + usersNoVoted + "\n" + preference, true);

				} else {
					chat.sendMessage(SUCCESSFULLY + " but not all the users have been voted. \n" + measure + "\n"
							+ usersNoVoted + "\n" + preference, true);
				}
			} else {
				chat.sendMessage("The vote is over but no consensus has been reached.\n" + measure + "\n" + usersNoVoted
						+ "\n" + preference, true);
			}
			if (end.getBranchs() != null) {
				chat.sendMessage("The project has be merged.", false);
				chat.sendPhoto(end.getBranchs());
				return Chat.getDefaultState();
			} else {
				chat.sendMessageWithKeyboard("What do you want next?", State.getMsgId(end.getMessageId()), false,
						OPTIONS);
				return this;
			}

		} else {
			if (message.getText().equals(OPTIONS[1])) {//Select one option
				return ProjectManager8SelectBranchOption.getState(end.getProject(), end.getBranchGroup()).runAndNext(chat, message);
			}else { //revote
				Polling poll = State.SOCIO().startPoll(end.getProject(), State.getUser(message.getFrom()), end.getBranchGroup());
				chat.sendMessage("The"+ poll.getCardinalRound() +" round of the poll has begun. ", false);
				return Chat.getDefaultState();
			}
		}

	}
	

}
