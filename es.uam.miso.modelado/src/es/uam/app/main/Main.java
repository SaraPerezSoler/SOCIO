package es.uam.app.main;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import es.uam.app.channels.Channel;
import es.uam.app.channels.Pipe;
import es.uam.app.channels.telegramCommands.TelegramControl;
import es.uam.app.main.commands.BaseCase;
import es.uam.app.main.commands.Get;
import es.uam.app.main.commands.Help;
import es.uam.app.main.commands.History;
import es.uam.app.main.commands.MainCommand;
import es.uam.app.main.commands.NewProject;
import es.uam.app.main.commands.Projects;
import es.uam.app.main.commands.Redo;
import es.uam.app.main.commands.Reload;
import es.uam.app.main.commands.Statistics;
import es.uam.app.main.commands.Undo;
import es.uam.app.main.commands.UserProperties;
import es.uam.app.main.commands.Validate;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.parser.rules.MetemodelRule;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.LocalProjects;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import projectHistory.Msg;

public class Main {

	
	
	public enum MainCommandEnum {

		NEW_PROJECT("newproject", new NewProject()), 
		HISTORY_ALL(new History(History.ALL)), 
		HISTORY_USER(new History(History.USER)),
		HISTORY_ELEMENT(new History(History.ELEMENT)),
		HISTORY_ACTION(new History(History.ACTION)), 
		USER_MSG_STATISTICS(new Statistics(Statistics.USER_MSG)), 
		USER_ACTIONS_STATISTICS(new Statistics(Statistics.USER_ACTION)),
		USERS_ACCESS(new UserProperties(UserProperties.CREATE_LIST)),
		ADD_USERS_ACCESS(new UserProperties(UserProperties.ADD_USERS)),
		REMOVE_USERS_ACCESS(new UserProperties(UserProperties.REMOVE_USERS)),
		ABS_USER_MSG_STATISTICS(new Statistics(Statistics.ABS_USER_MSG)), 
		ABS_USER_ACTIONS_STATISTICS(new Statistics(Statistics.ABS_USER_ACTION)),
		ACTIONS_STATISTICS(new Statistics(Statistics.ACTION)), 
		RATE_STATISTICS(new Statistics(Statistics.RATE)), 
		PROJECTS(new Projects()), 
		UNDO(new Undo()), REDO(new Redo()), GET(new Get()), VALIDATE(new Validate()),
		HELP(new Help()), 
		BASE_CASE(new BaseCase()), RELOAD(new Reload());

		private String name=null;
		private String methodName;
		private Object[] parameters;

		private MainCommandEnum(String name, String methodName, Object[] parameters) {
			this.name=name;
			this.methodName = methodName;
			this.parameters = parameters;
		}
		
		private MainCommandEnum(String methodName, Object[] parameters) {
			this.methodName = methodName;
			this.parameters = parameters;
		}

		private MainCommandEnum(String methodName) {
			this.methodName = methodName;
			this.parameters = new Object[0];
		}
		
		private MainCommandEnum() {
			this.methodName = name();
			this.parameters = new Object[0];
		}

		public String getMethodName() {
			return methodName;
		}
		
		public Class<?>[] getParametersType(){
			Class<?>[] ret= new Class[parameters.length+1];
			ret[0]=Msg.class;
			int i=1;
			for (Object o: parameters){
				ret[i]=o.getClass();
				i++;
			}
			return ret;
		}
		
		public Object[] getParameters(Msg msg){
			Object[] ret= new Object[parameters.length+1];
			ret[0]=msg;
			int i=1;
			for (Object o: parameters){
				ret[i]=o;
				i++;
			}
			return ret;
		}
		
		public String getName(){
			if (this.name==null){
				return super.name();
			}
			return this.name;
		}
	}

	private static Map<String, Channel> channels = new HashMap<String, Channel>();
	private static final Pipe PIPE = new Pipe();
	public static Logger log = Logger.getLogger("Modelado");
	public static void main(String[] args) throws IOException {

		boolean basicConfiguration = true;
		boolean debug = false;
		for (String arg : args) {
			if (arg.equals("debug")) {
				debug = true;
			}
			if (arg.endsWith(".properties")) {
				PropertyConfigurator.configure(arg);
				basicConfiguration = false;
			}

		}
		TelegramControl.setDebug(debug);
		if (basicConfiguration) {
			BasicConfigurator.configure();
		}

		ini();

		try {
			LocalProjects.loadProjects();
		} catch (FatalException e) {
			log.fatal(e);
		} catch (Exception e) {
			log.fatal(e);
		}

		while (true) {
			ReceivedMessage m = PIPE.read();
			log.info("Mensaje recibido: " + m);
			readMessage(m);
		}

	}

	public static void registerChannel(Class<? extends Channel> channelClass) {

		try {
			log.info("Registrando canal: " + channelClass.getName());
			Constructor<? extends Channel> channelConstructor = channelClass.getConstructor(new Class[] { Pipe.class });

			if (channelConstructor != null) {
				Channel channel = channelConstructor.newInstance(PIPE);
				channels.put(channel.getChannelName(), channel);
				channel.run();
			}

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			log.error("Error al registrar channel: " + e.getMessage());
		} catch (NoSuchMethodException e) {
			log.error("Error al registrar channel: " + e.getMessage());
		}

	}

	public static void ini() {
		
		List<Class<? extends Channel>> channels=new ArrayList<>();
		new FastClasspathScanner(Channel.class.getPackage().getName())
				.matchSubclassesOf(Channel.class, channels::add).scan();

		for (Class<? extends Channel> c : channels) {
			registerChannel(c);
		}	
	
		
		
		List<Class<? extends ExtractionRule<MetaModelProject>>> rules= new ArrayList<>();
		new FastClasspathScanner(ExtractionRule.class.getPackage().getName()).matchSubclassesOf(MetemodelRule.class, rules::add).scan();		
		try {
			
			for (Class<? extends ExtractionRule<MetaModelProject>> r : rules) {
				MetaModelProject.registerRule(r);
			}

		} catch (NoSuchMethodException | SecurityException e) {
			log.error("Error al registrar regla: " + e.getMessage());
		}

	}

	public static void readMessage(Msg m) {
		try {
			MainCommandEnum command=MainCommandEnum.BASE_CASE;
			if (m.getCommand() == null || m.getCommand().equals("") || m.getCommand().equals(" ")) {
				command=MainCommandEnum.BASE_CASE;
			}

			for (MainCommandEnum mce : MainCommandEnum.values()) {
				if (m.getCommand().equalsIgnoreCase(mce.getName())) {
					command=mce;
				}
			}
			
			Method method=SocioData.class.getMethod(command.getMethodName(), command.getParametersType());
			method.invoke(SocioData.getSocioData(), command.getParameters(m));

		} catch (FatalException e) {
			log.fatal("Error al leer los comandos: " + e.getMessage());
		} catch (SendMessageExc e) {
			Channel c = channels.get(m.getChannel());
			c.answerMessage(m, e);
		} catch (Exception e) {
			log.error("Error al leer los comandos: " + e.getMessage());
		} catch (Throwable e) {
			 e.printStackTrace();
			//log.fatal("Error al leer los comandos: " + e);
		}

	}

}
