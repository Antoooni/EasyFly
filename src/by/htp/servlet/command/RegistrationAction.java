package by.htp.servlet.command;

import static by.htp.util.ConstantValue.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationAction implements CommandAction {
	String page=null;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//page = request.getParameter(PAGE_REGISTRATION);
//		request.setAttribute(REQUEST_PARAM_EXIST_USER, existUser);
//		HttpSession session = request.getSession(true);
//		session.setAttribute(REQUEST_PARAM_EXIST_USER, false);
		request.setAttribute(REQUEST_PARAM_EXIST_USER, false); 
		page= PAGE_REGISTRATION;
		return page;
	}

}
