package com.wy.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wy.dao.UserDAO;
import com.wy.entity.User;
import com.wy.service.UserService;

@Component("service")
@Scope("singleton")
public class UserServiceImpl implements UserService {
	UserDAO dao;
	
	public UserDAO getDao() {
		return dao;
	}
	
	@Resource(name="sqlDAO")
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void add(User user) {
//		System.out.println("当前对象的ID："+this);
		// TODO Auto-generated method stub
	   dao.save(user);
	}
}
