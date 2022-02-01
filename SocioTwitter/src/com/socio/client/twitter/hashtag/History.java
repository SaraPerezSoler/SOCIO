package com.socio.client.twitter.hashtag;

import java.util.List;

import com.socio.client.beans.Message;
import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class History implements HashTag{

	private static History HISTORY = new History();

	public static History getState() {
		return HISTORY;
	}

	private History() {
	}
	@Override
	public String getHashtag() {
		return "history";
	}

	@Override
	public String getDescription() {
		return "show a project's history";
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
		List<Message> messages = SOCIO.history(project, getUser(message.getUser(), twitter));
		sendHistory(messages, twitter, message, project);
	}
	
}
