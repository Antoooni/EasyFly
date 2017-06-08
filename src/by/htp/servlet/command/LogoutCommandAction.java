package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import by.htp.service.AuthorizationService;

public class LogoutCommandAction implements CommandAction {

//	private AuthorizationService authorizationService;
	
//	public LogoutCommandAction() {
//		authorizationService = new AuthorizationServiceImpl();
//	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		session.invalidate();
		String page = null;
		page = PAGE_DEFAULT;
		return page;
	}

}
