package com.abc.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class LoggedInInfoBean implements Serializable { // session scoped beans must be serializable

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
