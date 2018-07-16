package com.socio.client.twitter.hashtag;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Help implements HashTag {
	private static Help HELP = new Help();

	public static Help getState() {
		return HELP;
	}

	private Help() {
	}
	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse{
		String[] help=SOCIO.help();
		twitter.sendMessage(message.getId(),message.getUser().getScreenName(), help[0]+help[1],null, null);
	}

	@Override
	public String getHashtag() {
		return "help";
	}

	@Override
	public String getDescription() {
		return "give you a help web page";
	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		run(twitter, message);
		
	}

}
