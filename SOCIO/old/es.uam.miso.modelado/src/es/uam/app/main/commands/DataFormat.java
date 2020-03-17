package es.uam.app.main.commands;

import java.util.List;
import socioProjects.Project;
import socioProjects.User;
import socioProjects.Visibility;

public interface DataFormat {

	public default String printProjectCanWrite(User user, List<Project> write) {
		String ret = "";
		if (!write.isEmpty()) {
			ret += "\nProjects that " + user.getNick() + " can edit:\n";
			ret += printProject(write);
		}
		return ret;
	}

	public default String printProjectCanRead(User user, List<Project> read) {
		String ret = "";
		if (!read.isEmpty()) {
			ret += "\nProjects that " + user.getNick() + " can read:\n";
			ret += printProject(read);
		}
		return ret;
	}

	public default String printOwnProject(User user, List<Project> list) {
		String cad = "";
		if (list.isEmpty()) {
			cad = "The user " + user.getNick() + " doesn't have own projects.";
		}
		if (user.getNick().endsWith("s")) {
			cad = user.getNick() + "' projects:\n";
		} else {
			cad = user.getNick() + "'s projects:\n";
		}

		cad += printProject(list);
		return cad;

	}

	public default String printVisibilityProjects(Visibility v, List<Project> projects) {
		if (projects.isEmpty()) {
			return "I don't have projects with the visibility " + v.name();
		}

		String ret = "Projects with visibility " + v.name() + ":\n";
		ret += printProject(projects);
		return ret;

	}

	public default String printProject(List<Project> list) {
		String cad = "";
		for (Project p : list) {
			cad += "> " + p.getProjectData() + "\n";
		}
		return cad;
	}
	
	public default String printOrderProject(List<Project> list) {
		String cad = "";
		int i=1;
		for (Project p : list) {
			//cad += i+". " + p.getCompleteName() + "\n";
			cad += i+". " + p.getName() + "\n";
			i++;
		}
		return cad;
	}

	public default String printUsers(List<User> list) {
		String cad = "";
		for (User u : list) {
			cad+=printAUser(u);
		}
		return cad;
	}

	public default String printAUser(User u) {
		String cad = "";

		cad += "· " + u.getChannel() + '/' + u.getNick() + "\n";

		return cad;
	}
}
