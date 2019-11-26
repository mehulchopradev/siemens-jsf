package com.abc.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.abc.domain.User;
import com.abc.service.UserServiceIntf;

@ManagedBean(name="rb")
public class RegisterBean {

	// always use wrapper java types since they have value null - blank field
	private String username;
	
	private Integer password;
	
	private String country;
	
	private String gender;
	
	private boolean regSuccess;
	
	private Integer confirmPassword;
	
	private boolean spouseNameVisible;
	
	private boolean adharVisible;
	
	@ManagedProperty(value="#{userServiceBean}")
	private UserServiceIntf userService;
	
	public RegisterBean() {
		this.gender = "M";
		this.country = "CH";
	}

	public String getUsername() {
		return username;
	}

	public Integer getPassword() {
		return password;
	}

	public String getCountry() {
		return country;
	}

	public String getGender() {
		return gender;
	}
	
	public UserServiceIntf getUserService() {
		return userService;
	}

	public void setUsername(String username) {
		System.out.println(username);
		this.username = username;
	}

	public void setPassword(Integer password) {
		System.out.println(password);
		this.password = password;
	}

	public void setCountry(String country) {
		System.out.println(country);
		this.country = country;
		
		if (country.equals("IN")) {
			this.adharVisible = true;
		} else {
			this.adharVisible = false;
		}
	}

	public void setGender(String gender) {
		System.out.println(gender);
		this.gender = gender;
	}
	
	public String getRegisterStatus() {
		return null;
	}
	
	public void setRegisterStatus(String status) {
		this.regSuccess = status.equals("success") ? true : false;
	}
	
	public void setUserService(UserServiceIntf userService) {
		this.userService = userService;
	}
	
	public boolean isRegSuccess() {
		return regSuccess;
	}
	
	public Integer getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(Integer confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public boolean isSpouseNameVisible() {
		return spouseNameVisible;
	}
	
	public void setSpouseNameVisible(boolean spouseNameVisible) {
		this.spouseNameVisible = spouseNameVisible;
	}
	
	public void onMarriedClick(ActionEvent event) {
		this.spouseNameVisible = true;
	}
	
	public boolean isAdharVisible() {
		return adharVisible;
	}

	public void setAdharVisible(boolean adharVisible) {
		this.adharVisible = adharVisible;
	}
	
	// action controller function
	// runs after the setters

	// getters are called at the time of sending the form to the client
	// setters are called at the time of accepting the form data from the client
	public String register() {
		if (userService.userExists(this.username)) {
			FacesMessage facesMessage = new FacesMessage("Username already taken");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("registerForm:username", facesMessage);
			return null; // redisplay back the same form
		}

		System.out.println("register function");
		System.out.println(this.username);
		System.out.println(this.password);
		System.out.println(this.gender);
		System.out.println(this.country);
		
		userService.register(new User(this.username, this.password, this.gender, this.country));
		
		return "/public/login?faces-redirect=true&reg=success";
	}
}
