package es.uam.app.channels.telegramCommands;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class ProjectManagement extends TelegramCommand {
	
	private Map<Long, Integer> state= new HashMap<Long, Integer>();
	private Map<Long, String> projectName= new HashMap<Long, String>();
	
	private static final int SELECT_PROJECT=1;
	private static final int SELECT_OPTION=2;
	private static final int VISIBILITY_OPTION=3;
	private static final int USER_OPTION=4;
	private static final int USER_OPTION_REMOVE=5;
	private static final int USER_OPTION_ADD=6;
	private static final int USER_OPTION_CHANGE=7;
	private static final int USER_OPTION_EDIT=8;
	private static final int USER_OPTION_READ=9;
	private static final int BRANCH_OPTION = 10;
	
	private static final String[] OPTIONS={"Change project visibility", "Manage project users"};
	private static final String BRANCH_GROUP="Set branch group";
	private static final String[] CONST={"Public", "Protected", "Private"};
	private static final String[] USER={"Add an user to the project", "Remove an user to the project", "Change an user access"};
	
	private static final String[] ADD_OPTIONS={"Read", "Write"};
	private static final String EXIT="exit";
	private static final String CONSENSUS = "/selectBranchFor ";
	
	

	public ProjectManagement(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getDescription() {
		return "Project management: change visibility, add permision to a user.";
	}

	@Override
	public String getCommand() {
		return "projectmanagement";
	}

	@Override
	public void commandAction(Update update) {
		String text=update.getMessage().getText();
		String[] split = text.split(" ");
		this.setState(update.getMessage().getChatId());
	
		// Si el comando no tiene argumentos
		if (split.length == 1) {
			this.state.put(update.getMessage().getChatId(), SELECT_PROJECT);
			this.tChannel.write(update, CommandList.PROJECTS_FOR_USER, null,null, null);
		} else {
			this.state.put(update.getMessage().getChatId(), SELECT_OPTION);
			this.tChannel.write(update, CommandList.PROJECT_INFO, split[1], null, null);
		}
	}
	
	
	
	
	@Override
	public void modellingAnswer(long chatId, int msgId, Msg rMessage, SendMessageExc sMessage) {
		
		this.setState(chatId);
		
		if (state.get(chatId)==SELECT_PROJECT){
			String text=sMessage.getText();
			
			String[][] projects=getProjects(text);
			
			if (projects.length<1){
				this.setStandardState(chatId);
				sMessage.setText("You don't have projects to management. You can create a project with /newproject.");
				tChannel.sendMessage(msgId, chatId, sMessage);
				return;
			} 
			
			sMessage.setText("Which project?");
			tChannel.sendMessageWithKeyBoar(msgId,chatId, sMessage, projects);
		}else if (state.get(chatId)==SELECT_OPTION){
			if (sMessage.hasText() && sMessage.getText().startsWith(ProjectNotFoundException.PROJECT_NOT_FOUND)){
				projectName.put(chatId, null);
				tChannel.sendMessage(msgId, chatId, sMessage);
			}else{
				String[][] options;
				if (super.projectInfoIsBranch(sMessage.getText())){
					options=new String[][]{{OPTIONS[0]},{OPTIONS[1]},{BRANCH_GROUP}, {EXIT}};
				}else if (super.projectInfoHasBranch(sMessage.getText())){
					options=new String[][]{{OPTIONS[0]},{OPTIONS[1]},{CONSENSUS+projectName.get(chatId)}, {EXIT}};
				}else{
					options=new String[][]{{OPTIONS[0]},{OPTIONS[1]}, {EXIT}};
				}
				sMessage.setText(super.getProjectsFormat(sMessage.getText())+"\n\nWhat do you want to do?");
				tChannel.sendMessageWithKeyBoar(msgId,chatId, sMessage, options);
			}
		}else if (state.get(chatId)==USER_OPTION_REMOVE || state.get(chatId)==USER_OPTION_CHANGE){
			if (sMessage.hasText()){
				String [] split= sMessage.getText().split(">");
				if (split.length==1){
					this.setStandardState(chatId);
					sMessage.setText("This project doesn't have users to remove");
					tChannel.sendMessage(msgId, chatId, sMessage);
				}else{
					String [][] options= new String[split.length-1][1];
					for (int i=0; i<split.length-1; i++){
						options[i][0]=split[i+1].split("\n")[0];
					}
					sMessage.setText("Who?");
					tChannel.sendMessageWithKeyBoar(msgId, chatId, sMessage, options);
					
				}
			}
		}
	}
	
	@Override
	public void userAnswerText(Update update) {
		int msgId=update.getMessage().getMessageId();
		long chatId=update.getMessage().getChatId();
		if (state.get(chatId)==SELECT_PROJECT){
			this.state.put(chatId, SELECT_OPTION);
			this.projectName.put(update.getMessage().getChatId(), update.getMessage().getText());
			this.tChannel.write(update, CommandList.PROJECT_INFO, update.getMessage().getText(), null, null);
			
		}else if(state.get(chatId)==SELECT_OPTION){
			if (update.getMessage().getText().equals(OPTIONS[0])){
				this.state.put(chatId, VISIBILITY_OPTION);
				SendMessageExc sMsg=new SendMessageExc("Visibility:");
				this.tChannel.sendMessageWithKeyBoar(msgId, chatId, sMsg, new String[][]{{CONST[0]},{CONST[1]},{CONST[2]},{EXIT}});
						
			}else if (update.getMessage().getText().equals(OPTIONS[1])){
				this.state.put(chatId, USER_OPTION);
				SendMessageExc sMsg=new SendMessageExc("What?:");
				this.tChannel.sendMessageWithKeyBoar(msgId, chatId, sMsg, new String[][]{{USER[0]},{USER[1]},{USER[2]},{EXIT}});
			}else if (update.getMessage().getText().equals(BRANCH_GROUP)){
				this.state.put(chatId, BRANCH_OPTION);
				SendMessageExc sMessage=new SendMessageExc("Write the name of the group branch:");
				this.tChannel.sendMessageAndWait(msgId, chatId, sMessage);
			}else{
				exit(update);
			}
		}else if(state.get(chatId)==VISIBILITY_OPTION){
			this.setStandardState(chatId);
			if (update.getMessage().getText().equals(CONST[0])){ //Public	
				tChannel.write(update, CommandList.CHANGE_VISIBILITY, projectName.get(chatId), null,"PUBLIC");
				
			}else if (update.getMessage().getText().equals(CONST[1])){ //Protected
				tChannel.write(update, CommandList.CHANGE_VISIBILITY, projectName.get(chatId), null,"PROTECTED");
				
			}else if (update.getMessage().getText().equals(CONST[2])){ //Private
				tChannel.write(update, CommandList.CHANGE_VISIBILITY, projectName.get(chatId), null,"PRIVATE");
				
			}else{//SKip
				exit(update);
			}
		}else if(state.get(chatId)==USER_OPTION){
			if (update.getMessage().getText().equals(USER[0])){ //Add user	
				SendMessageExc sMessage= new SendMessageExc("What kind of access?");
				tChannel.sendMessageWithKeyBoar(msgId, chatId, sMessage, new String[][]{{ADD_OPTIONS[0]},{ADD_OPTIONS[1]},{EXIT}});
				this.state.put(chatId, USER_OPTION_ADD);
				
			}else if (update.getMessage().getText().equals(USER[1])){ //remove user
				this.state.put(chatId, USER_OPTION_REMOVE);
				tChannel.write(update, CommandList.USERS_PROJECT, projectName.get(chatId), null,null);

			}else if (update.getMessage().getText().equals(USER[2])){//change user
				this.state.put(chatId, USER_OPTION_CHANGE);
				tChannel.write(update, CommandList.USERS_PROJECT, projectName.get(chatId), null,null);
			}else{//SKip
				exit(update);
			}
		}else if(state.get(chatId)==USER_OPTION_ADD){
			if (update.getMessage().getText().equals(ADD_OPTIONS[0])){//Read
				SendMessageExc sMessage= new SendMessageExc("Who? (<nickname> if it is in telegram or <channel>/<nickname> if not)");
				tChannel.sendMessageAndWait(msgId, chatId, sMessage);
				this.state.put(chatId, USER_OPTION_READ);
			}else if (update.getMessage().getText().equals(ADD_OPTIONS[1])){//Edit
				SendMessageExc sMessage= new SendMessageExc("Who? (<nickname> if it is in telegram or <channel>/<nickname> if not)");
				tChannel.sendMessageAndWait(msgId, chatId, sMessage);
				this.state.put(chatId, USER_OPTION_EDIT);
			}else if (update.getMessage().getText().equals(EXIT)){
				exit(update);
			}else{
				SendMessageExc sMessage= new SendMessageExc("What kind of access?");
				tChannel.sendMessageWithKeyBoar(msgId, chatId, sMessage, new String[][]{{ADD_OPTIONS[0]},{ADD_OPTIONS[1]},{EXIT}});
			}
		}else if(state.get(chatId)==USER_OPTION_REMOVE){
			this.setStandardState(chatId);
			this.tChannel.write(update, CommandList.REMOVE_USER_TO_PROJECT, projectName.get(chatId), update.getMessage().getText(), null);
		}else if(state.get(chatId)==USER_OPTION_CHANGE){
			this.setStandardState(chatId);
			this.tChannel.write(update, CommandList.UPDATE_USER_TO_PROJECT, projectName.get(chatId), update.getMessage().getText(), null);

		}else if(state.get(chatId)==USER_OPTION_READ){
			this.setStandardState(chatId);
			this.tChannel.write(update, CommandList.ADD_USER_TO_PROJECT, projectName.get(chatId), update.getMessage().getText(), "READ");
		}else if(state.get(chatId)==USER_OPTION_EDIT){
			this.setStandardState(chatId);
			this.tChannel.write(update, CommandList.ADD_USER_TO_PROJECT, projectName.get(chatId), update.getMessage().getText(), "EDIT");
		}else if (state.get(chatId)==BRANCH_OPTION){
			this.setStandardState(chatId);
			this.tChannel.write(update, CommandList.SET_BRANCH_GROUP, projectName.get(chatId), null, update.getMessage().getText());
		}
	}
	

}
