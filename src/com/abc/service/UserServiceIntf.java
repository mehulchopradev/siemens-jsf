package com.abc.service;

import com.abc.domain.User;

public interface UserServiceIntf {

	void register(User user);
	
	User authenticate(String username, Integer password);
	
	boolean userExists(String username);
}
