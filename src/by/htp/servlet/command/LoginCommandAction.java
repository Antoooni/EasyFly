package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bin.FlightDirection;
import by.htp.bin.User;
import by.htp.service.AuthorizationService;
import by.htp.service.DirectionService;
import by.htp.service.factory.ServiceFactory;
import by.htp.servlet.ForwardPage;

public class LoginCommandAction implements CommandAction {

	private AuthorizationService authorizationService;
	private DirectionService directionService;

	public LoginCommandAction() {
		authorizationService = ServiceFactory.getInstance().getAuthorizationService();
		directionService = ServiceFactory.getInstance().getDirectionService();

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);

		HttpSession session = request.getSession(true);
		String page = PAGE_DEFAULT;
		User user = new User();
		user = authorizationService.userData(login, password);
		// try {
		if (user != null) {
			List<FlightDirection> flightDirection = directionService.listDirections();
			// вывести список направлений dropdown
			session.setAttribute(REQUEST_PARAM_LIST_DIRECTION, flightDirection);

			session.setAttribute(REQUEST_PARAM_SESSION_USERNAME, user.getUserName());
			session.setAttribute(REQUEST_PARAM_SESSION_USER, user);
			page = PAGE_HOME;
		} else {
			page = PAGE_ERROR;
		}

		ForwardPage.forwardPage(request, response, page);
	}

}
