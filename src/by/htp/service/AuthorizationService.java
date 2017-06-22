package by.htp.service;

import by.htp.bin.User;

public interface AuthorizationService {
	User userData(String login, String password);
}
