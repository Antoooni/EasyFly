package by.htp.service;

import by.htp.bin.User;
import by.htp.dao.UserAuthorizationDao;
import by.htp.dao.factory.DaoFactory;


public class AuthorizationServiceImpl implements AuthorizationService {
	private UserAuthorizationDao daoNme;
//	DaoFactory daoFactory =  new DaoFactory();
	

	public AuthorizationServiceImpl() {
		daoNme = DaoFactory.getInstance().getUserAuthorizationDao();
		
	}

	@Override
	public User userData(String login, String password) {
		return daoNme.getUserData(login, password);
	}

}
