package com.socio.client.twitter.hashtag;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class ProjectManagementBranchGroup implements HashTag {
	private static ProjectManagementBranchGroup PROJECT_MANAGEMENT = new ProjectManagementBranchGroup();
	public static ProjectManagementBranchGroup getState() {
		return PROJECT_MANAGEMENT;
	}

	private ProjectManagementBranchGroup() {
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse {
		Project p = getProject(message);
		if (p != null) {
			run(twitter, message, p);
		}
	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		if (project.isBranch()) {
			twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "Under construction", project, null);
		}else {
			throw new ForbiddenResponse("Only the branchs have branch group");
		}
	}

	@Override
	public String getHashtag() {
		return "setbranchgroup";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
