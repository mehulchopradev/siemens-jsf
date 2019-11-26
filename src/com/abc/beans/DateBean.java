package com.abc.beans;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;

// By default RequestScoped
// Created for every request and destroyed when response sent back to the clients
@ManagedBean
public class DateBean {
	private String message;

	public DateBean() {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (hour >= 0 && hour < 12) {
			this.message = "Good Morning";
		} else if (hour >= 12 && hour < 16) {
			this.message = "Good Afternoon";
		} else {
			this.message = "Good Evening";
		}
	}
	public String getMessage() {
		// getters in JSF can be called more than once
		// keep them thin. i.e. they shuld return a pre computed value
		return this.message;
	}
}
