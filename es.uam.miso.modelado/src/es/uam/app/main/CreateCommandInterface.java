package es.uam.app.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import es.uam.app.main.commands.MainCommand;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class CreateCommandInterface {

	public static List<MainCommand> commands = new ArrayList<MainCommand>();
	public static Logger log = Logger.getLogger("Modelado");

	public static void main(String[] args) throws IOException {

		boolean basicConfiguration = true;

		for (String arg : args) {
			if (arg.endsWith(".properties")) {
				PropertyConfigurator.configure(arg);
				basicConfiguration = false;
			}
		}

		if (basicConfiguration) {
			BasicConfigurator.configure();
		}

		ini();

		FileWriter fichero = new FileWriter("./CommandList.java");
		PrintWriter pw = new PrintWriter(fichero);

		pw.println(createHead());
		for (MainCommand mc: commands){
			pw.print(javaDocStart());
			pw.println("\t* "+mc.getDesc().replace("\n", "\n\t* "));
			pw.println("\t* Needs: "+mc.getNeeds().replace("\n", "\n\t* "));
			pw.println("\t*/\n");
			pw.println("\tpublic static final String "+ mc.getName()+"=\""+mc.getName()+"\";\n");
		}
		pw.println("}");
		
		pw.close();

	}

	public static String javaDocStart() {
		return "\t/**@author Sara Pérez-Soler\n";
	}

	public static String createHead() {
		return "package es.uam.app.channels;\n\n" 
				+ "public interface CommandList {\n\n" + javaDocStart()
				+ "\t* To send a msg without a command, to send a new user\n" 
				+ "\t* */\n"
				+ "\tpublic static final String NO_COMMAND=\"NO_COMMAND\";\n\n";
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
			log.error("Error al registrar channel: " + e.getMessage());
		} catch (NoSuchMethodException e) {
			log.error("Error al registrar channel: " + e.getMessage());
		}

	}

	public static void ini() {

		// Registrando commands
		List<Class<? extends MainCommand>> commands = new ArrayList<>();
		new FastClasspathScanner(MainCommand.class.getPackage().getName())
				.matchSubclassesOf(MainCommand.class, commands::add).scan();

		for (Class<? extends MainCommand> c : commands) {
			registerMainCommand(c);
		}
	}

}
