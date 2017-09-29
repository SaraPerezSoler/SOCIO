package es.uam.app.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.CreateMsg;
import projectHistory.Msg;
import projectHistory.impl.projectHistoryFactoryImpl;
import removeLog.impl.RemoveLogFactoryImpl;
import socioProjects.Access;
import socioProjects.Contribution;
import socioProjects.Project;
import socioProjects.SocioApp;
import socioProjects.User;
import socioProjects.Visibility;
import socioProjects.impl.ProjectImpl;
import socioProjects.impl.SocioProjectsFactoryImpl;
import socioProjects.impl.SocioProjectsPackageImpl;

public class SocioData {

	private static ResourceSet resourceSet = null;
	private Resource resource;
	public final static String PROJECTS_PATH = "./projects";
	protected final static String FILENAME = "socioData.xmi";
	private SocioApp socioApp;

	public enum ProjectType {
		METAMODEL, MODEL
	}

	private static SocioData socioData = null;

	/**
	 * Genera el resourceSet para despues obtener el resource del ecore.
	 * 
	 * @return
	 */

	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			// Especificamos la extension del fichero (para todos los ficheros),
			// y indicamos que
			// es un XMI.
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put("socioProjects", SocioProjectsPackageImpl.eINSTANCE);
		}
		return resourceSet;
	}

	public static SocioData getSocioData() throws FatalException {
		if (socioData == null) {
			socioData = new SocioData();
		}
		return socioData;
	}

	private SocioData() throws FatalException {
		File file = new File(PROJECTS_PATH + "/" + FILENAME);
		if (file.exists()) {
			try {
				resource = getResourceSet().getResource(URI.createURI(PROJECTS_PATH + "/" + FILENAME), true);
				socioApp = (SocioApp) resource.getContents().get(0);
				List<Project> remove=new ArrayList<>();
				for (Project p: socioApp.getProjects()){
					try{
					p.initialize();
					}catch (FatalException e) {
						remove.add(p);
					}
				}
				socioApp.getProjects().removeAll(remove);
			} catch (Exception e) {
				e.printStackTrace();
				throw new FatalException("In class " + this.getClass().getName() + ": the file " + PROJECTS_PATH + "/"
						+ FILENAME + " can be opened");
			}
		} else {
			this.resource = getResourceSet().createResource(URI.createURI(PROJECTS_PATH + "/" + FILENAME));
			socioApp = SocioProjectsFactoryImpl.eINSTANCE.createSocioApp();
			resource.getContents().add(socioApp);
			save();
		}

		save();
	}

	public void save() {
		try {
			/*
			 * Save the resource
			 */
			resource.save(null);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public User getUser(String nick, String channel) {
		List<User> users = socioApp.getUsers();
		for (User u : users) {
			if (u.getNick().equalsIgnoreCase(nick) && u.getChannel().equalsIgnoreCase(channel)) {
				return u;
			}
		}
		return null;

	}

	public User getUser(long id, String channel) {
		List<User> users = socioApp.getUsers();
		for (User u : users) {
			if (u.getId() == id && u.getChannel().equalsIgnoreCase(channel)) {
				return u;
			}
		}
		return null;
	}

	public User getUser(long id) {
		List<User> users = socioApp.getUsers();
		List<User> usersValid = new ArrayList<>();
		for (User u : users) {
			if (u.getId() == id) {
				usersValid.add(u);
			}
		}
		if (usersValid.size() > 1) {
			int numAleat = (int) Math.floor(Math.random() * usersValid.size() + 1);
			return usersValid.get(numAleat);
		} else if (usersValid.size() < 1) {
			return null;
		} else {
			return usersValid.get(0);
		}
	}

	public User getUser(String nick) {
		List<User> users = socioApp.getUsers();
		List<User> usersValid = new ArrayList<>();
		for (User u : users) {
			if (u.getNick().equalsIgnoreCase(nick)) {
				usersValid.add(u);
			}
		}
		if (usersValid.size() > 1) {
			int numAleat = (int) Math.floor(Math.random() * usersValid.size() + 1);
			return usersValid.get(numAleat);
		} else if (usersValid.size() < 1) {
			return null;
		} else {
			return usersValid.get(0);
		}
	}

	public Project getProject(String name, User u) {
		List<Project> projects = socioApp.getProjects();
		for (Project p : projects) {
			if (p.getName().equals(name) && p.getAdmin().equals(u)) {
				return p;
			}
		}
		return null;
	}

	public Project getProject(long id) {
		List<Project> projects = socioApp.getProjects();
		for (Project p : projects) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public List<Project> getProjects(User user) {
		return user.getOwnProjects();
	}

	public List<Project> getProjects() {
		return socioApp.getProjects();
	}

	public List<User> getUsers() {
		return socioApp.getUsers();
	}

	public User addUser(User u) {
		User aux;
		if (u.getId() != -1) {
			aux = getUser(u.getId(), u.getChannel());
		} else {
			aux = getUser(u.getNick(), u.getChannel());
		}

		if (aux == null) {
			socioApp.getUsers().add(u);
			save();
			return u;
		} else {
			aux.setId(u.getId());
			aux.setNick(u.getNick());
			aux.setName(u.getName());
			save();
			return aux;
		}
	}

	public void addProject(Project p, User u) throws SendMessageExc {
		Project aux = getProject(p.getName(), u);
		if (aux == null) {
			p.setAdmin(u);
			u.getOwnProjects().add(p);
		} else {
			throw new SendMessageExc("The project " + p.getName() + " from the user " + u.getNick() + " already exist");
		}
	}

	public void createProject(String name, Msg msg, ProjectType type, Visibility constraint) throws Exception {
		Project aux = getProject(name, msg.getUser());
		if (aux != null) {
			throw new SendMessageExc(
					"The project " + name + " from the user " + msg.getUser().getNick() + " already exist");
		}

		Project p;
		if (type == ProjectType.METAMODEL) {
			p = SocioProjectsFactoryImpl.eINSTANCE.createMetamodelProject();
		} else {
			p = SocioProjectsFactoryImpl.eINSTANCE.createModelProjec();
		}

		p.setName(name);
		p.setHistory(projectHistoryFactoryImpl.eINSTANCE.createHistory());
		p.setRemove(RemoveLogFactoryImpl.eINSTANCE.createRoot());
		p.setId(ProjectImpl.getNextId());
		p.setVisibility(constraint);
		addProject(p, msg.getUser());
		p.initialize();

		CreateMsg cmsg = projectHistoryFactoryImpl.eINSTANCE.createCreateMsg();
		cmsg.setDate(msg.getDate());
		cmsg.setId(msg.getId());
		cmsg.setSentence(msg.getText());
		cmsg.setText(msg.getMsg());
		cmsg.setUser(msg.getUser());

		p.getHistory().setCreateMsg(cmsg);
		socioApp.getProjects().add(p);
		save();
	}

	public void removeProject(String name, Msg msg) throws Exception {
		Project aux = getProject(name, msg.getUser());
		if (aux == null) {
			throw new SendMessageExc(
					"The project " + name + " from the user " + msg.getUser().getNick() + " not exist");
		}

		List<User> users = socioApp.getUsers();
		for (User u : users) {
			u.removeContribution(aux);
		}
		aux.getAdmin().getOwnProjects().remove(aux);
		socioApp.getProjects().remove(aux);

		save();
	}

	public void removeProject(Project p, Msg msg) throws Exception {

		List<User> users = socioApp.getUsers();
		for (User u : users) {
			u.removeContribution(p);
		}
		p.remove();
		socioApp.getProjects().remove(p);
		save();
	}

	public String getProjectForUser(User user) {
		List<Project> projects = user.getOwnProjects();
		if (projects.isEmpty()) {
			return "The user " + user.getNick() + " doesn't have own projects.";
		}
		String ret;
		if (user.getNick().endsWith("s")) {
			ret = user.getNick() + "' projects:\n";
		} else {
			ret = user.getNick() + "'s projects:\n";
		}
		for (Project p : projects) {
			ret += "> " + p.getProjectData() + "\n";
		}

		return ret;
	}

	public String getProjectsForVisibility(Visibility v) {
		List<Project> projects = getProjects();

		int count = 0;
		String ret = "Projects with visibility " + v.getName() + ":\n";
		for (Project p : projects) {
			if (p.getVisibility().equals(v)) {
				ret += "> " + p.getProjectData() + "\n";
				count++;
			}
		}
		if (count == 0) {
			ret = "I don't have projects with visibility " + v.getName() + "\n";
		}
		return ret;
	}

	public String getProjectsForUserPermision(User user) {
		String ret = getProjectForUser(user);

		List<Contribution> contributionProjects = user.getContributions();
		List<Project> read = new ArrayList<>();
		List<Project> write = new ArrayList<>();
		for (Contribution c : contributionProjects) {
			if (c.getAccess().equals(Access.EDIT)) {
				write.add(c.getProject());
			} else {
				read.add(c.getProject());
			}
		}

		if (!write.isEmpty()) {
			ret += "\nProjects that " + user.getNick() + " can edit:\n";
			for (Project p : write) {
				ret += "> " + p.getProjectData() + "\n";
			}
		}
		if (!read.isEmpty()) {
			ret += "\nProjects that " + user.getNick() + " can read:\n";
			for (Project p : read) {
				ret += "> " + p.getProjectData() + "\n";
			}
		}

		ret += "\n" + getProjectsForVisibility(Visibility.PUBLIC);
		return ret;
	}

	public String getAllProjects() {
		String ret = getProjectsForVisibility(Visibility.PUBLIC);
		ret += "\n" + getProjectsForVisibility(Visibility.PROTECTED);
		ret += "\n" + getProjectsForVisibility(Visibility.PRIVATE);
		return ret;
	}

	public String getProjectData(Project p) {
		List<User> users = getUsers();

		String ret = "Project: " + p.getProjectData() + "\n";
		ret += "Visibility: " + p.getVisibility().getName() + "\n";

		String usersCanEdit = "Users can edit:\n";
		String usersCanRead = "Users can read:\n";
		for (User u : users) {
			if (u.canEdit(p)) {
				usersCanEdit += "> " + u.getNick() + ", " + u.getChannel() + "\n";
			} else if (u.canRead(p)) {
				usersCanRead += "> " + u.getNick() + ", " + u.getChannel() + "\n";
			}
		}
		ret += usersCanEdit + "\n" + usersCanRead;

		return ret;
	}

}
