package es.uam.app.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uam.app.actions.ActionModel;

public class SendHistoryMsg extends SendMessageExc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Log> logs = new ArrayList<Log>();

	public class Log {
		private String userName;
		private Date date;
		private String msg;
		private List<String> actions;

		private Log(String userName, Date date, String msg, List<String> actions) {
			super();
			this.userName = userName;
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
			String cad= userName + "(" + date + "):" + msg+"\n";
			for (String s: actions){
				cad+="\t"+s+"\n";
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
	
	public void addLog(String userName, Date date, String msg, List<ActionModel> actions){
		List<String> actionsString= new ArrayList<>();
		for (ActionModel a: actions){
			actionsString.add(a.toString());
		}
		
		logs.add(new Log(userName, date, msg, actionsString));
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
