package com.wy.action;

import javax.annotation.Resource;

import com.wy.entity.User;
import com.wy.service.UserService;


public class UserAction {
	User user;
	UserService service;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public UserService getService() {
		return service;
	}

	@Resource(name="service")
	public void setService(UserService service) {
		this.service = service;
	}

	public String add(){
		service.add(user);
		return "main";
	}
}
