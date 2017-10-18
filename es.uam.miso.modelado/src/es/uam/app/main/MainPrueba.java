package es.uam.app.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import es.uam.app.main.commands.MainCommand;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import es.uam.app.parser.rules.ExtractionRule;
import es.uam.app.parser.rules.MetemodelRule;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import projectHistory.Msg;
import projectHistory.impl.projectHistoryFactoryImpl;
import socioProjects.MetamodelProject;
import socioProjects.User;
import socioProjects.impl.MetamodelProjectImpl;
import socioProjects.impl.SocioProjectsFactoryImpl;

public class MainPrueba {

	public static List<MainCommand> commands = new ArrayList<MainCommand>();
	public static Logger log = Logger.getLogger("Modelado");
	private static User user;

	public static void main(String[] args) throws IOException {

		boolean basicConfiguration = true;

		for (String arg : args) {
			if (arg.equals("debug")) {
			}
			if (arg.endsWith(".properties")) {
				PropertyConfigurator.configure(arg);
				basicConfiguration = false;
			}

		}
		if (basicConfiguration) {
			BasicConfigurator.configure();
		}

		try {
			SocioData.getSocioData();
		} catch (FatalException e) {
			log.fatal(e);
		} catch (Exception e) {
			log.fatal(e);
		}

		ini();

		while (true) {
			Msg m = getMsg();
			log.info("Mensaje recibido: " + m);
			readMessage(m);
		}

	}

	public static Msg getMsg() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("What do you want to do?");

		for (int i = 0; i < commands.size(); i += 2) {
			if (commands.get(i + 1) != null) {
				System.out.println((i + 1) + ". " + commands.get(i).getName() + "\t\t" + (i + 2) + ". "
						+ commands.get(i + 1).getName());
				// System.out.println("\t\tNeeds: "+m.getNeeds() );
			} else{
				System.out.println(i + 1 + ". " + commands.get(i).getName());
			}
		}
		System.out.print("\n>");
		String command = br.readLine();
		System.out.println("Project: ");
		System.out.print("\n>");
		String projectName = br.readLine();
		System.out.println("User to search: ");
		System.out.print("\n>");
		String userToSearch = br.readLine();
		System.out.println("text: ");
		System.out.print("\n>");
		String text = br.readLine();

		Msg msg = projectHistoryFactoryImpl.eINSTANCE.createMsg();

		msg.setMsg("");
		msg.setUser(user);
		msg.setDate(new Date());
		msg.setCommand(command);
		msg.setProject(projectName);
		msg.setUserToSearch(userToSearch);
		msg.setId((Math.random() * 1000) + "");
		msg.setText(text);
		return msg;

	}

	public static void registerMainCommand(Class<? extends MainCommand> mainCommand) {

		try {
			log.info("Registrando mainCommand: " + mainCommand.getName());
			Constructor<? extends MainCommand> channelConstructor = mainCommand.getConstructor(new Class[] {});

			if (channelConstructor != null) {
				MainCommand command = channelConstructor.newInstance();
				commands.add(command);
			}

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			log.error("Error al registrar mainCommand: " + e.getMessage());
		} catch (NoSuchMethodException e) {
			log.error("Error al registrar mainCommand: " + e.getMessage());
		}

	}

	public static void ini() {

		user = SocioProjectsFactoryImpl.eINSTANCE.createUser();
		user.setName("Consola");
		user.setNick("Consola");
		user.setChannel("Consola");
		user.setId(1);

		// Registrando commands
		List<Class<? extends MainCommand>> commands = new ArrayList<>();
		new FastClasspathScanner(MainCommand.class.getPackage().getName())
				.matchSubclassesOf(MainCommand.class, commands::add).scan();

		for (Class<? extends MainCommand> c : commands) {
			registerMainCommand(c);
		}

		// Registrando Extraction Rules
		List<Class<? extends ExtractionRule<MetamodelProject>>> rules = new ArrayList<>();
		new FastClasspathScanner(ExtractionRule.class.getPackage().getName())
				.matchSubclassesOf(MetemodelRule.class, rules::add).scan();
		try {

			for (Class<? extends ExtractionRule<MetamodelProject>> r : rules) {
				MetamodelProjectImpl.registerRule(r);
			}

		} catch (NoSuchMethodException | SecurityException e) {
			log.error("Error al registrar regla: " + e.getMessage());
		}

	}

	public static void readMessage(Msg m) {

		try {
			m.setUser(SocioData.getSocioData().addUser(m.getUser()));
			String command;
			if (m.getCommand() == null || m.getCommand().equals(" ") || m.getCommand().isEmpty()) {
				command = "BASE_CASE";
			} else {
				command = m.getCommand();
			}

			for (MainCommand mc : commands) {
				if (command.equalsIgnoreCase(mc.getName())) {
					mc.execute(m);
				}
			}

		} catch (FatalException e) {
			log.fatal("Error al leer los comandos: " + e.getMessage());
		} catch (SendMessageExc e) {
			System.out.println(e.getText());
		} catch (Exception e) {
			log.error("Error al leer los comandos: " + e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			// log.fatal("Error al leer los comandos: " + e);
		}

	}

}
