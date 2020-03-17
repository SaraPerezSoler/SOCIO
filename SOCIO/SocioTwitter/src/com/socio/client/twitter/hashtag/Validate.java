package com.socio.client.twitter.hashtag;


import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Validate implements HashTag {
	private static Validate VALIDATE = new Validate();

	public static Validate getState() {
		return VALIDATE;
	}

	private Validate() {
	}
	/*@Override
	public void run(TwitterControl twitter, Status message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		if (!chat.hasProject()) {
			throw new NotProjectException();
		}
		String response = SOCIO.validate(chat.getProject(), State.getUser(message.getFrom()));
		chat.sendMessage(response, message.getMessageId(), false);
		return Chat.getDefaultState();
	}*/

	@Override
	public String getHashtag() {
		return "validate";
	}

	@Override
	public String getDescription() {
		return "validate the model";
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse {
		Project project = getProject(message);
		if (project != null) {
			run(twitter, message, project);
		}
	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		User user = getUser(message.getUser(), twitter);
		String response =  SOCIO.validate(project, user);
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), response, project, null);
	}

}
