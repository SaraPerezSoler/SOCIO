package es.uam.app.channels.telegram;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.main.Main;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.SentMessage;

public class Get extends TelegramCommand {

	private static final String GET_MSG = "Choose the project to get.";

	public Get(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "get";
	}

	@Override
	public String getDescription() {
		return "send a file with the model";
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
				tChannel.write(update, Main.MainCommandEnum.PROJECTS.getName(), "");

			} else {
				this.setStandardState(update.getMessage().getChatId());
				tChannel.write(update, Main.MainCommandEnum.GET.getName(), project);
			}

		} else {
			this.setStandardState(update.getMessage().getChatId());
			String text2 = text.replace(split[0] + " ", "");
			tChannel.write(update, Main.MainCommandEnum.GET.getName(), text2);
		}
	}

	@Override
	public void modellingAnswer(long chatId, int msgId, String rMessageCommand, SentMessage sMessage) {

		if (sMessage.getText() != null && sMessage.getText().startsWith(ProjectNotFoundException.PROJECT_NOT_FOUND)) {
			this.setStandardState(chatId);
			tChannel.sendMessageAndWait(msgId, chatId, sMessage);
		} else {
			this.setState(chatId);
			sMessage.setText(GET_MSG);
			tChannel.sendMessageAndWait(msgId, chatId, sMessage);
		}
	}

	@Override
	public void userAnswer(Update update) {
		this.setStandardState(update.getMessage().getChatId());
		tChannel.write(update, Main.MainCommandEnum.GET.getName(), update.getMessage().getText());
	}

}
