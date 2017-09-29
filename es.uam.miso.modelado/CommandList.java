package es.uam.app.channels;

public interface CommandList {

	/**@author Sara P�rez-Soler
	* To send a msg without a command, to send a new user
	* */
	public static final String NO_COMMAND="NO_COMMAND";


	/**@author Sara P�rez-Soler
	* Base case of the bot, analyzes a message in natural language(NL) to modify the model
	* if the msg doesnt have a text, the bot displays the current state of the model.
	* the user need permission to write to modify the model and permission to read to see the state
	* Needs: a project (channel/usernick/projectName), a sentence in NL
	*/

	public static final String BASE_CASE="BASE_CASE";

	/**@author Sara P�rez-Soler
	* downloads the meta-model in ecore format, the user needs permission to read
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String GET="GET";

	/**@author Sara P�rez-Soler
	* redirects to a web page with tips and examples to work with SOCIO
	* Needs: 
	*/

	public static final String HELP="HELP";

	/**@author Sara P�rez-Soler
	* send back all the msg with some action
	* Needs: a project (channel/usernick/projectName), the action (update, create, delete) in the field text
	*/

	public static final String HISTORY_ACTIONS="HISTORY_ACTIONS";

	/**@author Sara P�rez-Soler
	* sends back all the msg for a project
	* Needs: a project (channel/usernick/projectName), optional: one or two dates to filter and the order (ASCENDING/DESCENDING) 
	* to show (dd/MM/yyyy-dd/MM/yyyy-order) in the field text
	*/

	public static final String HISTORY_ALL="HISTORY_ALL";

	/**@author Sara P�rez-Soler
	* sends back all the mgs which modify a element
	* Needs: a project (channel/usernick/projectName), the name of a element in the text field
	*/

	public static final String HISTORY_ELEMENT="HISTORY_ELEMENT";

	/**@author Sara P�rez-Soler
	* sends back all the msg from a user
	* Needs: a project (channel/usernick/projectName), a user to search (channel/usernick)
	*/

	public static final String HISTORY_USER="HISTORY_USER";

	/**@author Sara P�rez-Soler
	* creates a new project
	* Needs: the name of the project (only the name)
	*/

	public static final String NEW_PROJECT="NEW_PROJECT";

	/**@author Sara P�rez-Soler
	* sends a list with all the projects
	* Needs: 
	*/

	public static final String PROJECTS="PROJECTS";

	/**@author Sara P�rez-Soler
	* sends all the project that the user who sends the msg has
	* Needs: 
	*/

	public static final String PROJECTS_FOR_USER="PROJECTS_FOR_USER";

	/**@author Sara P�rez-Soler
	* sends all the project that the user who sends the msg has some access
	* Needs: 
	*/

	public static final String PROJECT_USER_ACCESS="PROJECT_USER_ACCESS";

	/**@author Sara P�rez-Soler
	* sends all projects with some visibility
	* Needs: the visibility (Public, Private, Protected) in the field text
	*/

	public static final String PROJECTS_VISIBILITY="PROJECTS_VISIBILITY";

	/**@author Sara P�rez-Soler
	* all projects which belong to a user
	* Needs: a user to search (channel/usernick)
	*/

	public static final String PROJECTS_OWN="PROJECTS_OWN";

	/**@author Sara P�rez-Soler
	* redo the last undo
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String REDO="REDO";

	/**@author Sara P�rez-Soler
	* reload all the app, only the user root can do this
	* Needs: 
	*/

	public static final String RELOAD="RELOAD";

	/**@author Sara P�rez-Soler
	* remove a project, only the owner can do this
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String REMOVE_PROJECT="REMOVE_PROJECT";

	/**@author Sara P�rez-Soler
	* 
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String STA_ACTIONS="STA_ACTIONS";

	/**@author Sara P�rez-Soler
	* 
	* Needs: a project (channel/usernick/projectName), optional:a user to search (channel/usernick)
	*/

	public static final String STA_USER_ACTIONS="STA_USER_ACTIONS";

	/**@author Sara P�rez-Soler
	* 
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String STA_USER_ACTIONS_ABS="STA_USER_ACTIONS_ABS";

	/**@author Sara P�rez-Soler
	* 
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String PERCENT_AUTHORSHIP="PERCENT_AUTHORSHIP";

	/**@author Sara P�rez-Soler
	* 
	* Needs: a project (channel/usernick/projectName), optional: a user to search (channel/usernick)
	*/

	public static final String STA_USER_MSG="STA_USER_MSG";

	/**@author Sara P�rez-Soler
	* 
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String STA_USER_MSG_ABS="STA_USER_MSG_ABS";

	/**@author Sara P�rez-Soler
	* undo the last msg
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String UNDO="UNDO";

	/**@author Sara P�rez-Soler
	* verifies that the meta-model is correct, reporting all errors.
	* Needs: a project (channel/usernick/projectName)
	*/

	public static final String VALIDATE="VALIDATE";

}
