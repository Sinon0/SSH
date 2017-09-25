package com.wy.dao;


import com.wy.entity.User;

public interface UserDAO {
	/***
	 * save method
	 * @param user
	 */
	public void save(User user);
	//判断用户名是否重复方法
	public boolean isExists(User user);
	public User get(User user);
}
