package es.uam.app.main;

import java.io.IOException;
import java.lang.reflect.Constructor;
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
import es.uam.app.channels.telegram.TelegramControl;
import es.uam.app.main.commands.BaseCase;
import es.uam.app.main.commands.Get;
import es.uam.app.main.commands.Help;
import es.uam.app.main.commands.History;
import es.uam.app.main.commands.MainCommand;
import es.uam.app.main.commands.NewProject;
import es.uam.app.main.commands.Projects;
import es.uam.app.main.commands.Redo;
import es.uam.app.main.commands.Statistics;
import es.uam.app.main.commands.Undo;
import es.uam.app.main.commands.Validate;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.parser.rules.MetemodelRule;
import es.uam.app.projects.MetaModelProject;
import es.uam.app.projects.Project;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class Main {

	public enum MainCommandEnum {

		NEW_PROJECT("newproject", new NewProject()), 
		HISTORY_ALL(new History(History.ALL)), 
		HISTORY_USER(new History(History.USER)),
		HISTORY_ELEMENT(new History(History.ELEMENT)),
		HISTORY_ACTION(new History(History.ACTION)), 
		USER_MSG_STATISTICS(new Statistics(Statistics.USER_MSG)), 
		USER_ACTIONS_STATISTICS(new Statistics(Statistics.USER_ACTION)), 
		ABS_USER_MSG_STATISTICS(new Statistics(Statistics.ABS_USER_MSG)), 
		ABS_USER_ACTIONS_STATISTICS(new Statistics(Statistics.ABS_USER_ACTION)),
		ACTIONS_STATISTICS(new Statistics(Statistics.ACTION)), 
		RATE_STATISTICS(new Statistics(Statistics.RATE)), 
		PROJECTS(new Projects()), 
		UNDO(new Undo()), REDO(new Redo()), GET(new Get()), VALIDATE(new Validate()),
		HELP(new Help()), 
		BASE_CASE(new BaseCase());

		private String name;
		private MainCommand command;

		private MainCommandEnum(String name, MainCommand command) {
			this.name = name;
			this.command = command;
		}

		private MainCommandEnum(MainCommand command) {
			this.name = this.name().toLowerCase();
			this.command = command;
		}

		public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
			command.execute(rm);
		}

		public String getName() {
			return name;
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
			Project.loadProjects();
		} catch (FatalException e) {
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

	public static void readMessage(ReceivedMessage m) {
		try {
			if (m.getCommand() == null || m.getCommand().equals("") || m.getCommand().equals(" ")) {
				MainCommandEnum.BASE_CASE.execute(m);
			}

			for (MainCommandEnum mce : MainCommandEnum.values()) {
				if (m.getCommand().equalsIgnoreCase(mce.getName())) {
					mce.execute(m);
				}
			}

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
