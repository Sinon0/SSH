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
	
	/**
	 *@author Sinon
	 *register implement
	 */
	@Override
	public void add(User user) {
//		System.out.println("当前对象的ID："+this);
		// TODO Auto-generated method stub
	   dao.save(user);
	}

	/**
	 * 判断是否注册service接口实现
	 */
	@Override
	public boolean checkExists(User user) {
		// TODO Auto-generated method stub
		return dao.isExists(user);
	}

	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		return dao.get(user);
	}
}
