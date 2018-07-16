package es.uam.app.channels;

import es.uam.app.message.PrivateMsg;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public abstract class Channel extends Thread {

	private String channelName;
	private Pipe pipe;


	public Channel(String name, Pipe p) {
		this.channelName = name;
		this.pipe=p;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setchannelName(String name) {
		this.channelName = name;
	}

	public void write(Msg msg) {
		pipe.write(msg);
	}

	public abstract void answerMessage(Msg rMessage, SendMessageExc sMessage);
	public abstract void updateProject(SendMessageExc sMessage);
	public abstract void run();

	public abstract void sendPrivateMsg(Msg rMessage, PrivateMsg e);
}
