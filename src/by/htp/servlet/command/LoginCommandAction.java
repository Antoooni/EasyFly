package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bin.FlightDirection;
import by.htp.service.AuthorizationService;
import by.htp.service.DirectionService;
import by.htp.service.factory.ServiceFactory;

public class LoginCommandAction implements CommandAction {
	
	private AuthorizationService authorizationService;
	private DirectionService directionService;
	private ServiceFactory serviceFactory = new ServiceFactory();

	public LoginCommandAction() {
		authorizationService = serviceFactory.getAuthorizationService();
		directionService = serviceFactory.getDirectionService();

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);

		HttpSession session = request.getSession(true);
		String page = PAGE_DEFAULT;
		String userData;
		userData = authorizationService.userData(login, password);
		// try {
		if (userData != null) {
			List<FlightDirection> flightDirection = directionService.listDirections();
			// вывести список направлений dropdown
			request.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);

			session.setAttribute(REQUEST_PARAM_USER_NAME, userData);
			page = PAGE_AUTHORIZED;
		} else {
			page = PAGE_AUTHORIZED;
		}
		// }
		// catch (ServiceNoSuchUserException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// page = PAGE_ERROR;
		// request.setAttribute(REQUEST_PARAM_ERROR_MSG, e.getMessage());
		// }

		return page;
	}

}
