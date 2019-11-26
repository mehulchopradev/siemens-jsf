package com.abc.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ApplicationScoped
@ManagedBean(eager=true)
public class TodoBean {

	private HashMap<String, ArrayList<String>> todos;
	
	public TodoBean() {
		this.todos = new HashMap<>();
	}

	public List<String> getTodos(String username) {
		System.out.println(username);
		return this.todos.get(username);
	}
	
	public void addTodo(String username, String todo) {
		ArrayList<String> list;
		if (this.todos.containsKey(username)) {
			list = this.todos.get(username);
		} else {
			list = new ArrayList<>();
			this.todos.put(username, list);
		}
		
		list.add(todo);
	}
	
	public void removeTodo(String username, String todo) {
		if (this.todos.containsKey(username)) {
			this.todos.get(username).remove(todo);
		}
	}
}
