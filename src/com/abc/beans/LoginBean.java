package com.abc.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.abc.domain.User;
import com.abc.service.UserServiceIntf;

@ManagedBean
public class LoginBean {
	private String username;
	
	private Integer password;
	
	@ManagedProperty(value="#{userServiceBean}")
	private UserServiceIntf userService;
	
	@ManagedProperty(value="#{loggedInInfoBean}")
	private LoggedInInfoBean userInfoBean;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}
	
	public UserServiceIntf getUserService() {
		return userService;
	}

	public void setUserService(UserServiceIntf userService) {
		this.userService = userService;
	}

	public LoggedInInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(LoggedInInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}

	public String authenticate() {
		User user = userService.authenticate(username, password);
		if (user != null) {
			userInfoBean.setUsername(username);
			return "/private/home?faces-redirect=true";
		} else {
			FacesMessage message = new FacesMessage("Invalid username or password");
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/public/login?faces-redirect=true";
	}
}
