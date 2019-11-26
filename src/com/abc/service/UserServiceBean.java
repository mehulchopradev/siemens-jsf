package com.abc.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.abc.domain.User;

@ApplicationScoped
@ManagedBean(eager=true)
public class UserServiceBean implements UserServiceIntf {
	
	private List<User> userList;
	
	public UserServiceBean() {
		userList = new ArrayList<>();
	}

	@Override
	public void register(User user) {
		userList.add(user);
		System.out.println(this.userList);
	}

	@Override
	public User authenticate(String username, Integer password) {
		System.out.println(username);
		System.out.println(password);
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().intValue() == password.intValue()) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public boolean userExists(String username) {
		for (User user : userList) {
			if (user.getUsername().equals(username)) {
				return true;
			}
		}
		
		return false;
	}

}
