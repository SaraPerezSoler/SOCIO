package es.uam.app.twitter;

import java.io.File;
import java.util.List;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterControl {

	private Twitter twitter; 
	
	
	public TwitterControl() {
		try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey(ITwitterKeys.KEY)
        	  .setOAuthConsumerSecret(ITwitterKeys.SECRET)
        	  .setOAuthAccessToken(ITwitterKeys.TOKEN)
        	  .setOAuthAccessTokenSecret(ITwitterKeys.TOKEN_SECRET);
        	TwitterFactory tf= new TwitterFactory(cb.build());     
			twitter = tf.getInstance();
            twitter.verifyCredentials();
            //mi_twitter.updateStatus("Empiezo");
        } catch (TwitterException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
	}
	
	public List<Status> findTweet(){
		
		try {
			return twitter.getMentionsTimeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendMsg (String msg, File file){
		
		StatusUpdate status = new StatusUpdate(msg);
		if (file!=null){
			status.setMedia(file); // set the image to be uploaded here.
		}//status.setPossiblySensitive(true);
		try {
			twitter.updateStatus(status);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		}
	}

	public void sendAnswerMsg (long id,String msg, File file){
		
		StatusUpdate status = new StatusUpdate(msg);
		if (file!=null){
			status.setMedia(file);
		} 
		status.setInReplyToStatusId(id);
		try {
			twitter.updateStatus(status);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		}
	}

	
	public long getId() {
		try {
			return twitter.getId();
		} catch (IllegalStateException | TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}
