package es.uam.app.main.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendHistoryMsg;
import projectHistory.Action;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.impl.ProjectImpl;

public class HistoryAll extends MainCommand {


	public static final String ERROR_MENSAGE = "I don't fine history for this parametres:";
	public static final String ERROR_MENSAGE2_START = "The project ";
	public static final String ERROR_MENSAGE2_END = " is empty.";


	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

	public HistoryAll() {
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
			String[] split = rm.getText().split("-");
			if (split.length == 2) {
				try {
					Date date = formatter.parse(split[0]);
					int order;
					if (split[1].equalsIgnoreCase("DESCENDING")){
						order=ProjectImpl.DESCENDING;
					}else if (split[1].equalsIgnoreCase("ASCENDING")){
						order=ProjectImpl.ASCENDING;
					}else{
						throw new SendHistoryMsg(ERROR_MENSAGE + " from: " + date + " order: " + split[1]);
					}
					rmList = actual.getHistoryMsg(date, order);
					error = ERROR_MENSAGE + " from: " + date + " order: " + split[1];
				} catch (ParseException e) {
					rmList = new ArrayList<>();
					error = ERROR_MENSAGE + rm.getText();
				}
			} else if (split.length > 2) {
				try {
					Date start = formatter.parse(split[0]);
					Date end = formatter.parse(split[1]);
					int order;
					
					if (split[1].equalsIgnoreCase("DESCENDING")){
						order=ProjectImpl.DESCENDING;
					}else if (split[1].equalsIgnoreCase("ASCENDING")){
						order=ProjectImpl.ASCENDING;
					}else{
						throw new SendHistoryMsg(ERROR_MENSAGE + " from: " + formatter.format(start) + " to: " + formatter.format(end)
						+ " order: " + split[2]);
					}
					rmList = actual.getHistoryMsg(start, end, order);
					
					error = ERROR_MENSAGE + " from: " + formatter.format(start) + " to: " + formatter.format(end)
							+ " order: " + split[2];
				} catch (ParseException e) {
					rmList = new ArrayList<>();
					error = ERROR_MENSAGE + rm.getText();
				}
			} else {
				rmList = new ArrayList<>();
				error = ERROR_MENSAGE + rm.getText();
			}
		} else {
			rmList = actual.getHistoryMsg();
			error = ERROR_MENSAGE2_START + actual.getName() + ERROR_MENSAGE2_END;
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
		return "HISTORY_ALL";
	}

	@Override
	public String getDesc() {
		return "sends back all the msg for a project";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
