package es.uam.app.channels;

import java.io.File;

import es.uam.app.message.SendMessageExc;
import es.uam.app.twitter.TwitterControl;
import es.uam.app.twitter.TwitterStreamControl;
import projectHistory.Msg;
import projectHistory.impl.DslHistoryFactoryImpl;
import socioProjects.User;
import socioProjects.impl.SocioProjectsFactoryImpl;
import twitter4j.Status;
import twitter4j.UserStreamAdapter;

public class TwitterChannel extends Channel{
	
	private TwitterControl tc;
	private String name="ModellingBot";
	
	public TwitterChannel(Pipe p) {
		super("Twitter", p);
		tc = new TwitterControl();
	}
	
	@Override
	public void run() {
		TwitterStreamControl tsc = new TwitterStreamControl(new Adapter());
		tsc.monitorUser(Long.toString(tc.getId()));
	}
	
	private class Adapter extends UserStreamAdapter{
		
		public void onStatus(Status status) {
			Msg m = parseTweet(status);
			write(m);
		}
		
		private Msg parseTweet(Status s) {
			
			if (s.getUser().getId()==tc.getId()){
				return null;
			}
			String textTweet = s.getText();
			String[] tmpSplit = textTweet.split(" ");
			if (tmpSplit.length < 2) {
				return null;
			}
			if (!(tmpSplit[0].equals("@"+name))) {
				return null;
			}

			if (!(tmpSplit[1].startsWith("#"))) {
				return null;
			}
			
			String projectName = tmpSplit[1].replace("#", "");
			
			String sentence = "";
			for (int i = 2; i < tmpSplit.length; i++) {
				sentence += tmpSplit[i];
				if (i!=tmpSplit.length-1){
					sentence+=" ";
				}
			}

			User us= SocioProjectsFactoryImpl.eINSTANCE.createUser();
			us.setName(s.getUser().getName());
			us.setId(s.getUser().getId());
			us.setNick(s.getUser().getScreenName());
			us.setChannel(getChannelName());
					
			String msgId=Long.toString(s.getId());
			
			Msg msg = DslHistoryFactoryImpl.eINSTANCE.createMsg();
			msg.setMsg(s.getText());
			msg.setUser(us);
			msg.setDate( s.getCreatedAt());
			msg.setCommand("");
			msg.setProjectId(projectName);
			msg.setId(msgId);
			msg.setText(sentence);
			
			return msg;

		}
	}

	@Override
	public void answerMessage(Msg rMessage, SendMessageExc sMessage) {
		long id=Long.parseLong(rMessage.getId());
		
		String text;
		if (!sMessage.hasText()){
			text=rMessage.getProjectId();
		}else{
			text=sMessage.getText();
		}
		String msg="@"+rMessage.getUser().getNick()+" "+text;
		File png=null;
		if (sMessage.hasPng()){
			png=sMessage.getPng();
		}else{
			if (sMessage.hasDocument()){
				png=sMessage.getDocument();
			}
		}
		
		
		
		tc.sendAnswerMsg(id, msg, png);
		
	}

	@Override
	public void updateProject(SendMessageExc sMessage) {
		// TODO Auto-generated method stub
		
	}






}
