package es.uam.app.main.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendHistoryMsg;
import es.uam.app.projects.LocalProjects;
import projectHistory.impl.ActionImpl;

public class History extends MainCommand {

	public static final int ALL = 0;
	public static final int USER = 1;
	public static final int ELEMENT = 2;
	public static final int ACTION = 3;

	public static final String ERROR_MENSAGE = "I don't fine history for this parametres:";
	public static final String ERROR_MENSAGE2_START = "The project ";
	public static final String ERROR_MENSAGE2_END = " is empty.";

	public enum Order {
		ASCENDING, DESCENDING;

		private String desc;

		private Order() {
			this.desc = name().toLowerCase();
		}

		public String getDesc() {
			return desc;
		}

		public static Order get(String text) {
			if (text.equalsIgnoreCase(DESCENDING.name())) {
				return DESCENDING;
			}
			return ASCENDING;
		}
	}

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	private int option = ALL;

	public History(int option) {
		this.option = option;
	}

	@Override
	public void execute(ReceivedMessage rm) throws Exception {
		
		String nameProject = validProjectName(rm.getProjectName());

		LocalProjects actual = LocalProjects.getProject(nameProject);
		if (actual == null) {
			throw new ProjectNotFoundException(nameProject);
		}
		
		if (!(rm.getUser().canRead(actual))){
			throw new NotAccessException("");
		}

		String values;
		if (!rm.hasText()) {
			option = ALL;
			values = null;
		} else {
			values = rm.getText();
		}

		List<ReceivedMessage> rmList;
		String error;
		switch (option) {
		case USER:
			rmList = actual.getHistoryUser(values);
			error = ERROR_MENSAGE + " usernick= " + values;
			break;
		case ELEMENT:
			rmList = actual.getHistoryElement(values);
			error = ERROR_MENSAGE + " element= " + values;
			break;
		case ACTION:
			rmList = actual.getHistoryAction(values);
			error = ERROR_MENSAGE + " action= " + values;
			break;

		default:
			if (values != null) {
				String[] split = values.split("-");
				if (split.length == 2) {
					try {
						Date date = formatter.parse(split[0]);
						Order order = Order.get(split[1]);
						rmList = actual.getHistory(date, order);
						error = ERROR_MENSAGE + " from: " + date + " order: " + order.getDesc();
					} catch (ParseException e) {
						rmList = new ArrayList<>();
						error = ERROR_MENSAGE + values;
					}
				} else if (split.length > 2) {
					try {
						Date start = formatter.parse(split[0]);
						Date end = formatter.parse(split[1]);
						Order order = Order.get(split[2]);
						rmList = actual.getHistory(start, end, order);
						error = ERROR_MENSAGE + " from: " + formatter.format(start) + " to: " + formatter.format(end) + " order: " + order.getDesc();
					} catch (ParseException e) {
						rmList = new ArrayList<>();
						error = ERROR_MENSAGE + values;
					}
				} else {
					rmList = new ArrayList<>();
					error = ERROR_MENSAGE + values;
				}
			} else {
				rmList = actual.getHistory();
				error = ERROR_MENSAGE2_START + actual.getName() + ERROR_MENSAGE2_END;
			}

			break;
		}
		SendHistoryMsg msg;
		if (rmList.isEmpty()) {
			msg = new SendHistoryMsg(error);
		} else {
			msg = new SendHistoryMsg();
			for (ReceivedMessage rmLog : rmList) {
				List<ActionImpl> ams = new ArrayList<ActionImpl>();
				Map<String, List<ActionImpl>> sentences = rmLog.getSentencesActions();
				Set<String> keys = sentences.keySet();
				for (String k : keys) {
					ams.addAll(sentences.get(k));
				}
				msg.addLog(rmLog.getUser().getNick(),rmLog.getUser().getChannel(), rmLog.getDate(), rmLog.getMsg(), ams);
			}
		}

		throw msg;

	}

}
