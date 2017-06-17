package by.htp.dao;

import by.htp.bin.User;

public interface UserCreateDao {
	User createUser(User user);
	boolean checkExistUser(String login);
	boolean checkExistUserEmail(String email);
}
