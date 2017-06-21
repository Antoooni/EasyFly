package by.htp.service;

import by.htp.bin.User;
import by.htp.dao.UserCreateDao;
import by.htp.dao.factory.DaoFactory;

public class UserCreateServiceImpl implements UserCreateService{
	private UserCreateDao daoCreateUser;
	DaoFactory daoFactory = new DaoFactory() ;
	
	public UserCreateServiceImpl(){
		daoCreateUser = daoFactory.getUserCreateDao();
	}

	@Override
	public User createNewUser(User user) {
		User newUser = daoCreateUser.createUser(user);
		newUser.setUserName(user.getUserName());
		newUser.setUserSurname(user.getUserSurname());
		newUser.setUserEmail(user.getUserEmail());
		newUser.setTicket(null);
		return newUser;
	}

	@Override
	public boolean checkUserExist(String login) {
		
		return daoCreateUser.checkExistUser(login);
	}

	@Override
	public boolean checkUserEmailExist(String email) {
		
		return daoCreateUser.checkExistUserEmail(email);
	}
	

}
