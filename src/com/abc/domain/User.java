package com.abc.domain;

public class User {
	private String username;
	
	private Integer password;
	
	private String gender;
	
	private String country;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(String username, Integer password, String gender, String country) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.country = country;
	}


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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", gender=" + gender + ", country=" + country
				+ "]";
	}
}
