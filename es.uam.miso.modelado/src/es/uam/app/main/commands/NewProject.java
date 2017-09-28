package es.uam.app.main.commands;



import es.uam.app.main.SocioData;
import es.uam.app.main.SocioData.ProjectType;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Visibility;

public class NewProject extends MainCommand{

	public NewProject() {
	}

	@Override
	public void execute(Msg rm) throws Exception {
		if (!rm.hasProjectName()) {
			return;
		}
		try{
			String[] split=rm.getProjectName().split("/");
			if (split.length>1){
				rm.setProjectName(split[split.length-1]);
			}
			rm.setProjectName(validProjectName(rm.getProjectName()));
			searchProject(rm);
		}catch(ProjectNotFoundException e){
			Visibility c;
			if (rm.hasText()){
				c=Visibility.valueOf(rm.getText());
			}else{
				c=Visibility.PUBLIC;
			}
			SocioData.getSocioData().createProject(rm.getProjectName(), rm, ProjectType.METAMODEL, c);
			throw new SendMessageExc("Excellent! Now there is a new "+ c.name().toLowerCase()+" project with the name " + rm.getProjectName());
		}
		throw new SendMessageExc("A project with the name "+rm.getChannel()+"/"+rm.getUser().getNick()+"/"+rm.getProjectName()+" already exists");
		
	}

	@Override
	public String getName() {
		return "NEW_PROJECT";
	}

	@Override
	public String getDesc() {
		return "creates a new project";
	}

	@Override
	public String getNeeds() {
		return "the name of the project (only the name)";
	}

}
