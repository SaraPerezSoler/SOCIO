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
			String[] split=rm.getProject().split("/");
			if (split.length>1){
				rm.setProject(split[split.length-1]);
			}
			rm.setProject(validProjectName(rm.getProject()));
			searchProject(rm);
		}catch(ProjectNotFoundException e){
			Visibility c;
			if (rm.hasText()){
				c=Visibility.valueOf(rm.getText().toUpperCase());
			}else{
				c=Visibility.PUBLIC;
			}
			SocioData.getSocioData().createProject(rm.getProject(), rm, ProjectType.METAMODEL, c, false, null);
			throw new SendMessageExc("Excellent! Now there is a new "+ c.name().toLowerCase()+" project with the name " + rm.getProject());
		}
		throw new SendMessageExc("A project with the name "+rm.getChannel()+"/"+rm.getUser().getNick()+"/"+rm.getProject()+" already exists");
		
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
		return "the name of the project (only the name), optional: The visiblity (PUBLIC, PROTECTED, PRIVATE) in the text field.";
	}

}
