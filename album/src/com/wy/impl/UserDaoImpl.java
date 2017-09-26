package com.wy.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.wy.dao.UserDAO;
import com.wy.entity.User;

@Component(value="sqlDAO")//初始化bean 
public class UserDaoImpl implements UserDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/**
	 * register
	 */
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(user);
	}
	/**
	 *@author Sinon
	 *dao数据层用户是否存在方法实现
	 */
	@Override
	public boolean isExists(User user) {
		// TODO Auto-generated method stub
		//判断用户是否存在，通过hibernateTemplate查看数据库中有多少个User用户存在
		return hibernateTemplate.findByExample(user).size()>0;
	}

	/**
	 * 得到用户的所有信息
	 */
	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		List<User> list=hibernateTemplate.findByExample(user);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
