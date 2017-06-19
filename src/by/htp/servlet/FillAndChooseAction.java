package by.htp.servlet;

import static by.htp.util.ConstantValue.*;

import java.util.HashMap;

import by.htp.servlet.command.CommandAction;
import by.htp.servlet.command.CreateNewUserAction;
import by.htp.servlet.command.FlightInfoAction;
import by.htp.servlet.command.GoHomeAction;
import by.htp.servlet.command.LoginCommandAction;
import by.htp.servlet.command.LogoutCommandAction;
import by.htp.servlet.command.RegistrationAction;
import by.htp.servlet.command.SearchFlightAction;

public final class FillAndChooseAction {
	public HashMap<String, CommandAction> map() {
		HashMap<String, CommandAction> actionsMap = new HashMap<String, CommandAction>();
		actionsMap.put(ACTION_AUTHORISE, new LoginCommandAction());
		actionsMap.put(ACTION_LOGOUT, new LogoutCommandAction());
		actionsMap.put(ACTION_GO_HOME, new GoHomeAction());
		actionsMap.put(ACTION_SEARCH, new SearchFlightAction());
		actionsMap.put(ACTION_REGISTRATION, new RegistrationAction());
		actionsMap.put(ACTION_CREATE_USER, new CreateNewUserAction());
		actionsMap.put(ACTION_FLIGHT_INFO, new FlightInfoAction());
		
		return actionsMap;
	}
}
