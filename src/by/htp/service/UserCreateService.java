package by.htp.service;

import by.htp.bin.User;

public interface UserCreateService {
	public boolean checkUserExist(String login);
	public boolean checkUserEmailExist(String email);
	public User createNewUser(User user);

}
