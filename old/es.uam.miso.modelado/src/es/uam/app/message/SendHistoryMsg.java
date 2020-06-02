package es.uam.app.message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projectHistory.Action;

public class SendHistoryMsg extends SendMessageExc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Log> logs = new ArrayList<Log>();

	public class Log {
		private String userName;
		private String channel;
		private Date date;
		private String msg;
		private List<String> actions;

		private Log(String userName,String channel, Date date, String msg, List<String> actions) {
			super();
			this.userName = userName;
			this.channel=channel;
			this.date = date;
			this.msg = msg;
			this.actions = actions;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Date getDate() {
			return date;
		}

		public String getMsg() {
			return msg;
		}

		public List<String> getActions() {
			return actions;
		}

		@Override
		public String toString() {
			SimpleDateFormat fomartter= new SimpleDateFormat("dd/MM/yy hh:mm:ss");
			String cad= "User: "+userName + " at " + fomartter.format(date) +" in "+channel+ "\n send: " + msg+"\n\n";
			cad+="The message cause this actions:\n";
			for (String s: actions){
				cad+="\t· "+s+"\n";
			}
			return cad;
		}
	}

	public SendHistoryMsg() {
		super("");
	}
	public SendHistoryMsg(String errorMsg) {
		super(errorMsg);
	}
	
	public List<Log> getLogs() {
		return logs;
	}
	
	public void addLog(String userName,String channel,  Date date, String msg, List<Action> actions){
		List<String> actionsString= new ArrayList<>();
		for (Action a: actions){
			actionsString.add(a.toString());
		}
		
		logs.add(new Log(userName,channel, date, msg, actionsString));
	}
	@Override
	public String toString() {
		String cad="";
		for (Log l: logs){
			cad+=l.toString()+"\n----------------------------\n";
		}
		return cad;
	}

}
