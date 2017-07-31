package es.uam.app.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import es.uam.app.message.SendMessageExc;
import projectHistory.CreateMsg;
import projectHistory.Msg;
import projectHistory.impl.DslHistoryFactoryImpl;
import removeLog.impl.RemoveLogFactoryImpl;
import socioProjects.Project;
import socioProjects.SocioApp;
import socioProjects.User;
import socioProjects.Visibility;
import socioProjects.impl.SocioProjectsFactoryImpl;


public class SocioData{

	private static ResourceSet resourceSet = null;
	private Resource resource;
	public final static String PROJECTS_PATH = "./projects";
	protected final static String FILENAME = "socioData.xmi";
	private SocioApp socioApp;
	
	public enum ProjectType {
		METAMODEL, MODEL
	}
	
	private static SocioData socioData=null;
	
	/**
	 * Genera el resourceSet para despues obtener el resource del ecore.
	 * 
	 * @return
	 */
	
	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			// Especificamos la extension del fichero (para todos los ficheros), y indicamos que
			// es un XMI.
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",
					new XMIResourceFactoryImpl());
			resourceSet.getPackageRegistry().put("socioProjects", SocioProjectsFactoryImpl.eINSTANCE);
		}
		return resourceSet;
	}
	
	public static SocioData getSocioData(){
		if (socioData==null){
			socioData=new SocioData();
		}
		return socioData;
	}
	
	private SocioData() {
		File file= new File(PROJECTS_PATH+"/"+FILENAME);
		if (file.exists()){
			resource = getResourceSet().getResource(URI.createURI(PROJECTS_PATH+"/"+FILENAME), true);
			socioApp=(SocioApp) resource.getContents().get(0);
		}else{
			this.resource = getResourceSet().createResource(URI.createURI(PROJECTS_PATH+"/"+FILENAME));
			socioApp=SocioProjectsFactoryImpl.eINSTANCE.createSocioApp();
			resource.getContents().add(socioApp);
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
	
	public User getUser(String nick, String channel){
		List<User> users= socioApp.getUsers();
		for (User u: users){
			if (u.getNick().equalsIgnoreCase(nick) && u.getChannel().endsWith(channel)){
				return u;
			}
		}
		return null;
		
	}
	
	public User getUser(long id, String channel){
		List<User> users= socioApp.getUsers();
		for (User u: users){
			if (u.getId()==id && u.getChannel().endsWith(channel)){
				return u;
			}
		}
		return null;
	}

	
	public Project getProject (String name, User u){
		List<Project> projects= socioApp.getProjects();
		for (Project p: projects){
			if (p.getName().equals(name) && p.getAdmin().equals(u)){
				return p;
			}
		}
		return null;
	}
	
	public List<Project> getProjects(User user){
		return user.getOwnProjects();
	}
	
	public List<Project> getProjects(){
		return socioApp.getProjects();
	}
	
	public List<User> getUsers(){
		return socioApp.getUsers();
	}
	
	public void addUser(User u){
		User aux;
		if (u.getId()!=-1){
			aux=getUser(u.getId(), u.getChannel());	
		}else{
			aux=getUser(u.getNick(), u.getChannel());
		}
		
		if (aux==null){
			socioApp.getUsers().add(u);
		}else{
			aux.setId(u.getId());
			aux.setNick(u.getNick());
			aux.setName(u.getName());
		}
	}
	
	public void addProject(Project p, User u) throws SendMessageExc{
		Project aux=getProject(p.getName(), u);
		if (aux==null){
			u.getOwnProjects().add(p);
			p.setAdmin(u);
		}
		throw new SendMessageExc("The project "+p.getName()+" from the user "+u.getNick()+" already exist");
		
	}
	
	
	public void createProject(String name, Msg msg, ProjectType type, Visibility constraint) throws Exception {
		Project aux=getProject(name, msg.getUser());
		if (aux!=null){
			throw new SendMessageExc("The project "+name+" from the user "+msg.getUser().getNick()+" already exist");
		}
		
		Project p;
		if (type==ProjectType.METAMODEL){
			p= SocioProjectsFactoryImpl.eINSTANCE.createMetamodelProject();
		}else{
			p=SocioProjectsFactoryImpl.eINSTANCE.createModelProjec();
		}
		
		p.setName(name);
		p.setHistory(DslHistoryFactoryImpl.eINSTANCE.createHistory());
		p.setRemove(RemoveLogFactoryImpl.eINSTANCE.createRoot());		
		CreateMsg cmsg=DslHistoryFactoryImpl.eINSTANCE.createCreateMsg();
		cmsg.setDate(msg.getDate());
		cmsg.setId(msg.getId());
		cmsg.setSentence(msg.getText());
		cmsg.setText(msg.getMsg());
		cmsg.setUser(msg.getUser());
		
		p.getHistory().setCreateMsg(cmsg);
		
		addProject(p, msg.getUser());
		save();
	}
	
	public void removeProject(String name, Msg msg) throws Exception {
		Project aux=getProject(name, msg.getUser());
		if (aux==null){
			throw new SendMessageExc("The project "+name+" from the user "+msg.getUser().getNick()+" not exist");
		}
		
		List<User> users= socioApp.getUsers();
		for (User u: users){
			u.removeContribution(aux);
		}
		aux.getAdmin().getOwnProjects().remove(aux);
		socioApp.getProjects().remove(aux);
	
		save();
	}
	
	
	
}
