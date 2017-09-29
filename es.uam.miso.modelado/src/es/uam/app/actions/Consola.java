package es.uam.app.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import es.uam.app.channels.Channel;
import es.uam.app.channels.Pipe;
import es.uam.app.main.Main;
import es.uam.app.main.SocioData;
import es.uam.app.main.commands.MainCommand;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import projectHistory.projectHistoryFactory;
import socioProjects.Project;
import socioProjects.User;
import socioProjects.impl.SocioProjectsFactoryImpl;

public class Consola extends Channel {

	private static User userText = null;

	private static String project = null;
	private static long id = 0;

	public Consola(Pipe p) {
		super("Consola", p);
	}

	@Override
	public void answerMessage(Msg rMessage, SendMessageExc sMessage) {
		System.out.println(sMessage.getText());
		System.out.println(sMessage.getPng());

	}

	@Override
	public void updateProject(SendMessageExc sMessage) {
		// TODO Auto-generated method stub

	}

	private static User getUser() {
		if (userText == null) {
			userText = SocioProjectsFactoryImpl.eINSTANCE.createUser();
			userText.setChannel("Console");
			userText.setName("Console");
			userText.setNick("Console");
			userText.setId(1);
		}
		return userText;
	}

	@Override
	public void run() {


		System.out.println("Start!");
		try {
			while (true) {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Escriba un comando: ");
				int i = 1;
				for (MainCommand mc : Main.commands) {
					System.out.println("  " + i + ". " + mc.getName());
					i++;
				}
				System.out.print("> ");
				String comand = in.readLine();

				if (project == null|| project.isEmpty()) {
					System.out.println("Elija un proyecto: ");
					i = 1;
					for (Project p : SocioData.getSocioData().getProjects()) {
						System.out.println("  " + i + ". " + p.getName());
					}
					System.out.print("> ");
					project = in.readLine();
					
				}

				System.out.println("Escriba los argumentos: ");

				System.out.print("> ");
				String args = in.readLine();

				Msg msg = projectHistoryFactory.eINSTANCE.createMsg();
				msg.setDate(new Date());
				msg.setUser(getUser());
				msg.setCommand(comand);
				msg.setProject(project);
				msg.setId(id + "");
				msg.setText(args);
				msg.setMsg(args);
				id++;

				write(msg);
			}
		} catch (Exception e) {
			Main.log.fatal(e);
		}

	}

}
