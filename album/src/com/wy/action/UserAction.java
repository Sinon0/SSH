package com.wy.action;

import com.wy.entity.User;
import com.wy.service.UserDaoImpl;


public class UserAction {
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String add(){
		UserDaoImpl dao=new UserDaoImpl();
		dao.save(user);
		return "main";
	}
}
