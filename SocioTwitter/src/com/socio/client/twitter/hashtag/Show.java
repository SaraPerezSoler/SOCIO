package com.socio.client.twitter.hashtag;


import java.io.File;

import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Show implements HashTag {
	private static Show SHOW = new Show();

	public static Show getState() {
		return SHOW;
	}

	private Show() {
	}

	@Override
	public String getHashtag() {
		return "show";
	}

	@Override
	public String getDescription() {
		return "show a project";
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
		File f = SOCIO.edit(project, user, message.getText(), "", message.getCreatedAt(), Long.toString(message.getId()));
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "", project, f);
	}

}
