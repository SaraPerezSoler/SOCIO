/**
 * 
 */
package es.uam.app.main.commands;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.Visibility;

/**
 * @author Sara
 *
 */
public class ChangeVisibility extends MainCommand {

	/**
	 * 
	 */
	public ChangeVisibility() {
	}

	/* (non-Javadoc)
	 * @see es.uam.app.main.commands.MainCommand#execute(projectHistory.Msg)
	 */
	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual=searchProject(rm);
		if (!rm.getUser().isAdmin(actual)){
			throw new NotAccessException(" Only the project admin can do this.");
		}
		
		Visibility c;
		if (rm.hasText()){
			c=Visibility.valueOf(rm.getText().toUpperCase());
		}else{
			c=Visibility.PUBLIC;
		}
		SocioData.getSocioData().changeProjectVisibility(actual, c);
		throw new SendMessageExc("The project "+actual.getName()+" has been modify: \n\t>"+actual.getProjectData().replace("\n", "\n\t"));
	}

	/* (non-Javadoc)
	 * @see es.uam.app.main.commands.MainCommand#getName()
	 */
	@Override
	public String getName() {
		return "CHANGE_VISIBILITY";
	}

	/* (non-Javadoc)
	 * @see es.uam.app.main.commands.MainCommand#getDesc()
	 */
	@Override
	public String getDesc() {
		return "Change the visibility from a project";
	}

	/* (non-Javadoc)
	 * @see es.uam.app.main.commands.MainCommand#getNeeds()
	 */
	@Override
	public String getNeeds() {

		return project()+", the new visibility (in the text field)";
	}

}
