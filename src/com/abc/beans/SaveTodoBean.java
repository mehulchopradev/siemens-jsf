package com.abc.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean
public class SaveTodoBean {

	private String description;
	
	@ManagedProperty(value="#{todoBean}")
	private TodoBean todoBean;
	
	public TodoBean getTodoBean() {
		return todoBean;
	}
	
	public void setTodoBean(TodoBean todoBean) {
		this.todoBean = todoBean;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void saveTodo(String username) {
		todoBean.addTodo(username, this.description);
		this.description = null;
		
		FacesMessage message = new FacesMessage("Todo Saved", "Todo added for " + username);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void delete(String username, String todo) {
		todoBean.removeTodo(username, todo);
		
		FacesMessage message = new FacesMessage("Todo Removed", "Todo removed for " + username);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
