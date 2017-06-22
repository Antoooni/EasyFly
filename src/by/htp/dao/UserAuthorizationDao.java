package by.htp.dao;

import by.htp.bin.User;

public interface UserAuthorizationDao {
	User getUserData(String login, String password);
}
