package com.wy.service;

import com.wy.entity.User;

public interface UserService {
	/***
	 * 服务层
	 */
	public void add(User user);
	public boolean checkExists(User user);
	public User get(User user);
}
