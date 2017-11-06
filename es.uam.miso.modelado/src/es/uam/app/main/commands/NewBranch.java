package es.uam.app.main.commands;




import java.io.File;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class NewBranch extends MainCommand{

	public NewBranch() {
	}

	@Override
	public void execute(Msg rm) throws Exception {
		
		Project actual=searchProject(rm);
		if (actual.isBranch()){
			throw new SendMessageExc("A branch can't has a branch");
		}
		if (!rm.hasText()){
			throw new SendMessageExc("The branch needs a name");
		}
		
		Project p=SocioData.getSocioData().getProject(rm.getText(), rm.getUser());
		if (p!=null){
			throw new SendMessageExc("The project "+rm.getUser().getChannel()+"/"+rm.getUser().getNick()+"/"
					+rm.getText()+" already exits");
		}
		p=actual.getOpenBranch(rm.getText());
		Project p1=actual.getCloseBranch(rm.getText());
		if (p!=null || p1!=null){
			throw new SendMessageExc("The branch "+rm.getText()+" already exits in the project "
									+actual.getAdmin().getChannel()+"/"+actual.getAdmin().getNick()+"/"+actual.getName());
		}
		
		if (!rm.getUser().canEdit(actual)){
			throw new NotAccessException("The user needs write permissions to create a branch");
		}
		if (!rm.hasText()){
			throw new SendMessageExc("It's necessary the name of the branch and the branch group in the text field");
		}
		String[] split=rm.getText().split("-");
		String group;
		if (split.length==2){
			group=split[1];
		}else{
			group="default";
		}
		File png=SocioData.getSocioData().createBranch(actual, rm, validProjectName(split[0]), validProjectName(group));
		throw new SendMessageExc(png);
	}

	@Override
	public String getName() {
		return "NEW_BRANCH";
	}

	@Override
	public String getDesc() {
		return "creates a branch to a project";
	}

	@Override
	public String getNeeds() {
		return project()+", name to the new branch and the branch group (<name>-<groupName>) (in text field)";
	}

}
