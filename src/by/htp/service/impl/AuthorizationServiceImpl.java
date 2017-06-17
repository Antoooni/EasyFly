package by.htp.service.impl;

import by.htp.dao.UserAuthorizationDao;
import by.htp.dao.factory.DaoFactory;
import by.htp.service.AuthorizationService;


public class AuthorizationServiceImpl implements AuthorizationService {
	private UserAuthorizationDao daoNme;
	DaoFactory daoFactory =  new DaoFactory();
	

	public AuthorizationServiceImpl() {
		daoNme = daoFactory.getUserAuthorizationDao();
		
	}

	@Override
	public String userData(String login, String password) {
		String name = daoNme.getUserName(login, password);
		return name;
	}

}
