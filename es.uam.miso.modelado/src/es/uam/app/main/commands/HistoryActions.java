package es.uam.app.main.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendHistoryMsg;
import projectHistory.Action;
import projectHistory.Msg;
import socioProjects.Project;

public class HistoryActions extends MainCommand {

	public static final String ERROR_MENSAGE = "I don't fine history for this parametres:";
	public static final String ERROR_MENSAGE2_START = "The project ";
	public static final String ERROR_MENSAGE2_END = " is empty.";

	public HistoryActions() {
	}

	@Override
	public void execute(Msg rm) throws Exception {

		Project actual = searchProject(rm);

		if (!(rm.getUser().canRead(actual))) {
			throw new NotAccessException("");
		}

		List<Msg> rmList;
		String error;
		if (rm.hasText()) {
			rmList = actual.getHistoryForAction(rm.getText());
			error = ERROR_MENSAGE + " action= " + rm.getText();
		}else{
			rmList= new ArrayList<>();
			error=ERROR_MENSAGE;
		}

		SendHistoryMsg msg;
		if (rmList.isEmpty()) {
			msg = new SendHistoryMsg(error);
		} else {
			msg = new SendHistoryMsg();
			for (Msg rmLog : rmList) {
				List<Action> ams = new ArrayList<Action>();
				Map<String, List<Action>> sentences = rmLog.getSentencesMap();
				Set<String> keys = sentences.keySet();
				for (String k : keys) {
					ams.addAll(sentences.get(k));
				}
				msg.addLog(rmLog.getUser().getNick(), rmLog.getUser().getChannel(), rmLog.getDate(), rmLog.getMsg(),
						ams);
			}
		}

		throw msg;

	}
	
	@Override
	public String getName() {
		return "HISTORY_ACTIONS";
	}

	@Override
	public String getDesc() {
		return "send back all the msg with some action";
	}

	@Override
	public String getNeeds() {
		return project()+", the action (update, create, delete) in the field text";
	}

}
