package es.uam.app.main.commands;

import java.util.List;

import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.User;

public class FindUsers extends MainCommand {

	public FindUsers() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		if (rm.hasUserToSearch()){
			List<User> users=searchAllUser(rm.getUserToSearch());
			String cad="Users with nick "+rm.getUserToSearch();
			for (User u: users){
				cad+=">"+u.userInfo()+"\n";
			}
			throw new SendMessageExc(cad);
			
		}else{
			throw new SendMessageExc("Missing values");
		}
	}

	@Override
	public String getName() {
		return "FIND_USERS";
	}

	@Override
	public String getDesc() {
		return "Getting a username, it sends all users, in all channels, with this username";
	}

	@Override
	public String getNeeds() {
		return userToSearch()+" or username is userToSearch field";
	}

}
