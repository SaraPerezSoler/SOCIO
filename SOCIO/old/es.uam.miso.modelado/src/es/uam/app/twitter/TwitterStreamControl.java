package es.uam.app.twitter;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.UserStreamAdapter;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamControl {

	private TwitterStream twitterStream;
	
	public TwitterStreamControl(UserStreamAdapter listener) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(ITwitterKeys.KEY).setOAuthConsumerSecret(ITwitterKeys.SECRET)
				.setOAuthAccessToken(ITwitterKeys.TOKEN).setOAuthAccessTokenSecret(ITwitterKeys.TOKEN_SECRET);
		TwitterStreamFactory tsf = new TwitterStreamFactory(cb.build());

		twitterStream = tsf.getInstance();
		twitterStream.addListener(listener);
	}
	
	public void monitorUser (String userId){
		twitterStream.user(userId);
	}
}
