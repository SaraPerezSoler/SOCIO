package com.socio.client.twitter.hashtag;

import java.io.File;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Get implements HashTag {

	private static Get GET = new Get();

	public static Get getState() {
		return GET;
	}

	private Get() {
	}

	@Override
	public String getDescription() {
		return "send a file with the model";
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

		File file = SOCIO.get(project, getUser(message.getUser(), twitter));
		sendFile(file, twitter, message, project);

	}
	
	@Override
	public String getHashtag() {
		return "get";
	}

	
}
