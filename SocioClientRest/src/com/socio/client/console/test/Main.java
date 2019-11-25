package com.socio.client.console.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import com.socio.client.beans.Message;
import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.beans.User;
import com.socio.client.command.SocioCommands;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

public class Main {

	private static final User USER = new User("Console", "Console", "Sara", 1);
	private static final SocioCommands SOCIOCOMMANDS = SocioCommands.getSOCIO("http://localhost:80/Socio-rest/");

	public static void main(String[] args) throws Exception {
		boolean exit = false;
		
		while (!exit) {
			int option = getInt(getMenu());
			try {
			switch (option) {
			case 1:
				newProject();
				break;
			case 2:
				talk();
				break;
			case 3:
				undo();
				break;
			case 4:
				redo();
				break;
			case 5:
				projects();
				break;
			case 6:
				remove();
				break;
			case 7:
				changeVisibility();
				break;
			case 8:
				manageUsers();
				break;
			case 9:
				validate();
				break;
			case 10:
				statistics();
				break;
			case 11:
				history();
				break;
			case 12:
				get();
				break;
			case 13:
				help();
				break;
			default:
				exit = true;
				System.out.println("Hasta la proxima!");
				break;
			}}catch (ForbiddenResponse e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private static void help() throws ResponseError, ForbiddenResponse {
		String[] help = SOCIOCOMMANDS.help();
		for (String s : help) {
			System.out.println(s);
		}
	}

	private static String getString(String text) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.print(text + "\n> ");
		return br.readLine();
	}

	public static long getLong(String text) throws IOException {
		return Long.parseLong(getString(text));
	}

	private static Visibility getVisibility() throws IOException {
		int visibilityIndex = getInt("1. Public\n2. Protected\n3. Private");
		Visibility visibility;
		switch (visibilityIndex) {
		case 2:
			visibility = Visibility.PROTECTED;
			break;
		case 3:
			visibility = Visibility.PRIVATE;
			break;
		default:
			visibility = Visibility.PUBLIC;
			break;
		}
		return visibility;
	}

	private static int getInt(String text) throws IOException {
		return Integer.parseInt(getString(text));
	}

	private static String getMenu() {
		return "Select comand:\n" + "\t1. New Project\n" + "\t2. Talk\n" + "\t3. Undo\n" + "\t4. Redo\n"
				+ "\t5. Projects\n" + "\t6. Remove\n" + "\t7. Change project visibility\n"
				+ "\t8. Manage project users\n" + "\t9. Validate\n" + "\t10. Statistics\n" + "\t11. History\n"
				+ "\t12. Get\n" + "\t13. Help\n" + "\tnext. Exit";
	}

	private static void remove() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		System.out.println(SOCIOCOMMANDS.removeProject(project, USER));
	}

	private static void newProject() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		Visibility visibility = getVisibility();
		Project newproject = SOCIOCOMMANDS.newProject(project, USER, visibility);
		System.out.println(newproject);

	}

	private static void changeVisibility() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		Visibility visibility = getVisibility();
		Project proj = SOCIOCOMMANDS.changeVisibility(project, USER, visibility);
		System.out.println(proj);
	}

	private static void validate() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		System.out.println(SOCIOCOMMANDS.validate(project, USER));
	}

	static long id = 0;

	private static void talk() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		String text = getString("Send msg");

		File output = SOCIOCOMMANDS.edit(project, USER, text, text, new Date(), Long.toString(id++));
		moveFile(output);
		System.out.println(output.getAbsolutePath());

	}

	private static void undo() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		File output = SOCIOCOMMANDS.undo(project, USER, "undo", "undo", new Date(), Long.toString(id++));
		moveFile(output);
		System.out.println(output.getAbsolutePath());

	}

	private static void redo() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		File output = SOCIOCOMMANDS.redo(project, USER, "redo", "redo", new Date(), Long.toString(id++));
		moveFile(output);
		System.out.println(output.getAbsolutePath());

	}

	private static void moveFile(File output) {
		File f = new File("C:\\Users\\Sara\\Desktop\\" + output.getName());
		if (f.exists()) {
			f.delete();
		}
		output.renameTo(f);
	}

	private static void projects() throws IOException, ResponseError, ForbiddenResponse {
		String options = "Select one choice:\n" + "\t1. All projects\n" + "\t2. Projects belonging to a user\n"
				+ "\t3. Projects that a user can read\n" + "\t4. Projects that a user can write\n"
				+ "\t5. Project with a visiblity\n" + "\t6. A project information\n" + "\t7. Back";
		int option = getInt(options);
		List<Project> ret;
		String channel;
		String nick;
		switch (option) {
		case 1:
			ret = SOCIOCOMMANDS.projects();
			break;
		case 2:
			channel = getString("User channel");
			nick = getString("User nick");
			ret = SOCIOCOMMANDS.projects(new User(channel, nick, "", -1));
			break;
		case 3:
			channel = getString("User channel");
			nick = getString("User nick");
			ret = SOCIOCOMMANDS.projects(new User(channel, nick, "", -1), false);
			break;
		case 4:
			channel = getString("User channel");
			nick = getString("User nick");
			ret = SOCIOCOMMANDS.projects(new User(channel, nick, "", -1), true);
			break;
		case 5:
			Visibility visibility = getVisibility();
			ret = SOCIOCOMMANDS.projects(visibility);
			break;
		case 6:
			String project = getString("What project?");
			Project proj = SOCIOCOMMANDS.project(project);
			System.out.println(proj);
			return;
		default:
			return;
		}
		System.out.println(ret);

	}

	private static void manageUsers() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		int option = getInt(
				"1. Add a user into a project\n2. Remove a user to a project\n3. Change user privileges \n4. Back");
		String channel = getString("user channel");
		String user = getString("user nick");
		Project proj;
		switch (option) {
		case 1:

			int accessOption = getInt("1. Edit\n2. Read");
			boolean edit = true;
			if (accessOption == 2) {
				edit = false;
			}
			proj = SOCIOCOMMANDS.addUserToProject(project, USER, new User(channel, user, "", -1), edit);
			break;
		case 2:
			proj = SOCIOCOMMANDS.removeUserFromProject(project, USER, new User(channel, user, "", -1));
			break;
		case 3:
			proj = SOCIOCOMMANDS.updateUserInProject(project, USER, new User(channel, user, "", -1));
			break;
		default:
			return;
		}
		System.out.println(proj);
	}

	private static void statistics() throws IOException, ResponseError, ForbiddenResponse {
		int option = getInt("1. Msg from one user\n" + "2. Msg from all users\n" + "3. Actions from one user\n"
				+ "4. Actions from all users\n" + "5. All actions\n" + "6. Authorship\n" + "7. Back");
		String project = getString("projectName");

		boolean action = true;
		boolean absolute = false;
		if (option == 1 || option == 2) {
			action = false;
		}

		File out;
		if (option == 1 || option == 3) {
			String channel = getString("user channel");
			String userNick = getString("user nick");
			out = SOCIOCOMMANDS.statistics(project, USER, action, new User(channel, userNick, "", -1));
		} else if (option == 2 || option == 4) {
			int option2 = getInt("Sorted by date?:\n\t1. Yes\n\t2. No");
			if (option2 == 1) {
				absolute = false;
			} else {
				absolute = true;
			}
			out = SOCIOCOMMANDS.statistics(project, USER, action, absolute);
		} else if (option == 5) {
			out = SOCIOCOMMANDS.statisticsAllActions(project, USER);
		} else {
			out = SOCIOCOMMANDS.statisticsAuthorship(project, USER);
		}
		moveFile(out);
	}

	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

	private static void history() throws IOException, ParseException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		int option = getInt(
				"1. All messages\n2. Messages between dates\n3. Messages for an action\n4. Messages for an element\n5. Message from an user\n6. Project Histoy\n7. Back");
		List<Message> messages;
		switch (option) {
		case 2:
			String startDate = getString("Start Date (dd/MM/yyyy)");
			String endDate = getString("End date (dd/MM/yyyy) or press ENTR");
			Date start = null;
			if (!startDate.isEmpty()) {
				start = formatter.parse(startDate);
			}
			Date end = null;
			if (!endDate.isEmpty()) {
				end = formatter.parse(endDate);
			}
			messages = SOCIOCOMMANDS.history(project, USER, start, end);
			break;
		case 3:
			int option2 = getInt("Which action?\n\t1. Create\n\t2. Update\n\t3. Delete");
			String action;
			switch (option2) {
			case 1:
				action = "create";
				break;
			case 2:
				action = "update";
				break;
			default:
				action = "delete";
				break;
			}
			messages = SOCIOCOMMANDS.history(project, USER, action, true);
			break;
		case 4:
			String element = getString("Which elemet?");
			messages = SOCIOCOMMANDS.history(project, USER, element, false);
			break;
		case 5:
			String channel = getString("user channel");
			String nick = getString("user nick");
			messages = SOCIOCOMMANDS.history(project, USER, new User(channel, nick, "", -1));
			break;
		case 7:
			return;
		default:
			messages = SOCIOCOMMANDS.history(project, USER);
		}
		System.out.println(messages);
	}

	private static void get() throws IOException, ResponseError, ForbiddenResponse {
		String project = getString("projectName");
		File output = SOCIOCOMMANDS.get(project, USER);
		moveFile(output);
		System.out.println(output.getAbsolutePath());
	}

}