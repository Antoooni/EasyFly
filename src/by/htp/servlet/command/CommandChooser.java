package by.htp.servlet.command;

import by.htp.servlet.FillAndChooseAction;



/**
 * This class serves for choose user action
 * 
 * @author Anton Mazets
 * @version 1.0
 */
public class CommandChooser {
	/**
	 * This method receive string with user action from web page and returns new
	 * instance of required object
	 * 
	 * @param action
	 * @return
	 */

	public static CommandAction chooseAction(String action) {

		// HashMap<String, CommandAction> actionsMap = new HashMap<String,
		// CommandAction>();
		// actionsMap.put(ACTION_AUTHORISE, new LoginCommandAction());
		// actionsMap.put(ACTION_LOGOUT, new LogoutCommandAction());
		// actionsMap.put(ACTION_GO_HOME, new GoHomeAction());
		// actionsMap.put(ACTION_SEARCH, new SearchFlightAction());

		// switch(action){
		// case ACTION_AUTHORISE:
		// System.out.println("Login action: " + action);
		// return new LoginCommandAction();
		// case ACTION_LOGOUT:
		// System.out.println("Logout action: " + action);
		// return new LogoutCommandAction();
		// case ACTION_GO_HOME:
		// System.out.println("Go Home action: " + action);
		// return new GoHomeAction();
		// case ACTION_SEARCH:
		// System.out.println("Search action: " + action);
		// return new SearchFlightAction();
		// }
		FillAndChooseAction currentAction = new FillAndChooseAction();
		return currentAction.map().get(action);
	}

}
