package es.uam.app.channels.telegramCommands;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class Branch extends TelegramCommand {

	private static final String BRANC_MSG2="Alright, a new branch. How are we going to call it? "
			+ "Please choose a name for the branch.";
	private Map<Long, String> projectsName=new HashMap<>();
	
	private Map<Long, String> branchName=new HashMap<>();

	public Branch(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "branch";
	}

	@Override
	public String getDescription() {
		return "create a new branch for a project";
	}

	@Override
	public void commandAction(Update update) {
		this.removerUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());

		String text = update.getMessage().getText();
		String[] split = text.split(" ");
		this.setState(update.getMessage().getChatId());
		this.branchName.put(update.getMessage().getChatId(), null);
		
		// Si el comando no tiene argumentos
		if (split.length == 1) {
			String project = this.getProject(update.getMessage().getChatId());
			// Comprobamos si el chat tiene un proyecto asignado
			if (project == null || project.equals("")) {
				this.setStandardState(update.getMessage().getChatId());
				SendMessageExc msg=new SendMessageExc(STANDARD_ERROR_MSG);
				tChannel.sendMessage(update.getMessage().getMessageId(), update.getMessage().getChatId(), msg);
			} else {
				this.projectsName.put(update.getMessage().getChatId(), project);
				SendMessageExc msg=new SendMessageExc(BRANC_MSG2);
				tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(), msg);
			}

		} else {
			String text2 = text.replace(split[0] + " ", "");
			this.projectsName.put(update.getMessage().getChatId(), text2);
			SendMessageExc msg=new SendMessageExc(BRANC_MSG2);
			tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(), msg);
		}
	}

	@Override
	public void userAnswerText(Update update) {
		if (branchName.get(update.getMessage().getChatId())==null){
			String project=this.projectsName.get(update.getMessage().getChatId());
			branchName.put(update.getMessage().getChatId(), update.getMessage().getText());
			tChannel.write(update, CommandList.GET_OPEN_BRANCH_GROUP, project, null, null);
			
		}else{
			this.setStandardState(update.getMessage().getChatId());
			String project=this.projectsName.get(update.getMessage().getChatId());
			String branch=branchName.get(update.getMessage().getChatId());
			tChannel.write(update, CommandList.NEW_BRANCH, project, null, branch+"-"+update.getMessage().getText());
		}
		
		
	}
	
	@Override
	public void modellingAnswer(long chatId, int msgId, Msg rMessage, SendMessageExc sMessage) {
		String text=sMessage.getText();
		String[][]options=groupOptions(text);
		if (options.length==0){
			sMessage.setText("Write a branch group");
			tChannel.sendMessageAndWait(msgId, chatId, sMessage);
		}else{
			sMessage.setText(super.getProjectsFormat(text)+"\nSelect a branch group or write a new branch group: ");
			tChannel.sendMessageWithKeyBoar(msgId, chatId, sMessage, options);
			
		}
	}


}
