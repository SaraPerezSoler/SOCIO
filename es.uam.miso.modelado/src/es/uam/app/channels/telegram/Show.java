package es.uam.app.channels.telegram;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.main.Main;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;

public class Show extends TelegramCommand {

	private static final String SHOW_MSG = "Choose the project to see.";

	public Show(TelegramControl tChannel) {
		super(tChannel);

	}

	@Override
	public String getCommand() {
		return "show";
	}

	@Override
	public String getDescription() {
		return "show a project";
	}

	@Override
	public void commandAction(Update update) {
		this.removerUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());
		String text = update.getMessage().getText();
		String[] split = text.split(" ");
		// Si el comando no tiene argumentos
		if (split.length == 1) {
			String project = this.getProject(update.getMessage().getChatId());
			// Comprobamos si el chat tiene un proyecto asignado
			if (project == null || project.equals("")) {
				// si el chat no tiene un proyecto asignado,
				// enviamos la imagen con todos los proyectos y
				// esperamos respuesta.
				this.setState(update.getMessage().getChatId());
				tChannel.write(update, Main.MainCommandEnum.PROJECTS.getName(),"", "");

			} else {
				this.setStandardState(update.getMessage().getChatId());
				tChannel.write(update,"", project, "");
			}

		} else {
			this.setStandardState(update.getMessage().getChatId());
			String text2 = text.replace(split[0] + " ", "");
			tChannel.write(update,"", text2, "");
		}

	}

	@Override
	public void modellingAnswer(long chatId, int msgId, ReceivedMessage rMessageCommand, SendMessageExc sMessage) {

		if (sMessage.getText() != null && sMessage.getText().startsWith(ProjectNotFoundException.PROJECT_NOT_FOUND)) {
			this.setStandardState(chatId);
			tChannel.sendMessageAndWait(msgId, chatId, sMessage);
		} else {
			this.setState(chatId);
			sMessage.setText(SHOW_MSG);
			tChannel.sendMessageAndWait(msgId, chatId, sMessage);
		}
	}

	@Override
	public void userAnswerText(Update update) {
		this.setStandardState(update.getMessage().getChatId());
		tChannel.write(update,"", update.getMessage().getText(), "");
	}

}
