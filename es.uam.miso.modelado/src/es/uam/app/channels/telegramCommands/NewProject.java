package es.uam.app.channels.telegramCommands;

import java.util.HashMap;

import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.message.SendMessageExc;

public class NewProject extends TelegramCommand {

	private enum STATE{
		GET_PROJECT_NAME,CONF
	};

	private Map<Long, STATE> state= new HashMap<>();
	
	private static final String NEW_PROJECT_MSG = "Alright, a new project. How are we going to call it? "
			+ "Please choose a name for the project.";
	
	private static final String CONFIGURATION_MSG="Visibility:";

	
	private static final String[] CONST={"Public", "Protected", "Private", "Skip"};
	private Map<Long, String> projectName= new HashMap<>();



	public NewProject(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "newproject";
	}

	@Override
	public String getDescription() {
		return "create and set a new project";
	}

	@Override
	public void commandAction(Update update) {

		String text = update.getMessage().getText().toLowerCase();
		// Si hay users esperando el talk se limpia la lista.s
		this.removerAllUserTalk(update.getMessage().getChatId());

		String[] split = text.split(" ");
		// Si el comando no tiene argumentos
		if (split.length == 1) {
			this.setState(update.getMessage().getChatId());
			SendMessageExc sent = new SendMessageExc(NEW_PROJECT_MSG);
			tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(), sent);
			state.put(update.getMessage().getChatId(), STATE.GET_PROJECT_NAME);
		} else {
			this.setStandardState(update.getMessage().getChatId());
			String text2 = text.replace(split[0] + " ", "");
			tChannel.write(update, CommandList.NEW_PROJECT, text2,null, null);
			this.setProject(update.getMessage().getChatId(), text2);
			state.put(update.getMessage().getChatId(), STATE.CONF);
		}

	}

	@Override
	public void userAnswerText(Update update) {
		long id=update.getMessage().getChatId();
		STATE s=state.get(id);
		if (s==STATE.CONF) {
			this.setStandardState(id);
			this.setProject(id, projectName.get(id));
			if (update.getMessage().getText().equals(CONST[0])){ //Public	
				tChannel.write(update, CommandList.NEW_PROJECT, projectName.get(id), null,"PUBLIC");
				
			}else if (update.getMessage().getText().equals(CONST[1])){ //Protected
				tChannel.write(update, CommandList.NEW_PROJECT, projectName.get(id), null,"PROTECTED");
				
			}else if (update.getMessage().getText().equals(CONST[2])){ //Private
				tChannel.write(update, CommandList.NEW_PROJECT, projectName.get(id), null,"PRIVATE");
				
			}else{//SKip
				tChannel.write(update, CommandList.NEW_PROJECT, projectName.get(id), null,null);
			}
		}else if (s==STATE.GET_PROJECT_NAME){

			this.projectName.put(id, update.getMessage().getText());
			this.setState(update.getMessage().getChatId());
			SendMessageExc sMessage=new SendMessageExc(CONFIGURATION_MSG);
			tChannel.sendMessageWithKeyBoar(update.getMessage().getMessageId(), update.getMessage().getChatId(), sMessage, new String[][] {{CONST[0]},{CONST[1]},{CONST[2]},{CONST[3]}});
			state.put(update.getMessage().getChatId(), STATE.CONF);
		}
	}
 
}
