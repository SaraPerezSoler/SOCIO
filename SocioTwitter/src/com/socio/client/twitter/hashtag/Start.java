package com.socio.client.twitter.hashtag;


import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Start implements HashTag {

	private static final String WELCOME = "I can help you create and manager models.";

	private static Start START=null;
	public static Start getState() {
		if (START==null) {
			START=new Start();
		}
		return START;
	}
	
	private Start() {	
	}
	
	@Override
	public String getHashtag() {
		return "start";
	}

	@Override
	public String getDescription() {
		return "starts the bot";
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws ResponseError, ForbiddenResponse, TwitterException {
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), getStartMsg(),null ,null);
	}
	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		run(twitter, message);
	}

	private static String getStartMsg() {
		String ret = WELCOME + "\n\n";
		for (String key : TwitterControl.hashtagCommand.keySet()) {
			ret += "#" + TwitterControl.hashtagCommand.get(key).getHashtag() + "\n";
		}
		return ret;
	}

	
}
