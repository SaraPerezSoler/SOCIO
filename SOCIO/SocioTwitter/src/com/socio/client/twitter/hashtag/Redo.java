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

public class Redo implements HashTag {
	private static Redo REDO =new Redo();

	public static Redo getState() {
		return REDO;
	}
	
	private Redo() {
	}

	@Override
	public String getHashtag() {
		return "redo";
	}

	@Override
	public String getDescription() {
		return "redo the last undo";
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
		File f = SOCIO.redo(project, getUser(message.getUser(), twitter), message.getText(), "",new Date(), Long.toString(message.getId()));
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "", project, f);
	}

}
