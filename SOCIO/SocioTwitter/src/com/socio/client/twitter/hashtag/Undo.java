package com.socio.client.twitter.hashtag;

import java.io.File;
import java.util.Date;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Undo implements HashTag {
	private static Undo UNDO =new Undo();

	public static Undo getState() {
		return UNDO;
	}
	
	private Undo() {
	}

	@Override
	public String getHashtag() {
		return "undo";
	}

	@Override
	public String getDescription() {
		return "undo the last message";
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
		File f = SOCIO.undo(project, getUser(message.getUser(), twitter), message.getText(), "", new Date(), Long.toString(message.getId()));
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "", project, f);
	}

}
