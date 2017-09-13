package com.wy.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.wy.dao.UserDAO;
import com.wy.entity.User;

@Component(value="sqlDAO")//初始化bean
@Scope(value="singleton")//默认也是该类型
public class UserDaoImpl implements UserDAO {
	@Resource
	HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(user);
	}
	
	public void start(){
		System.out.println("Start........");
	}

	public void end(){
		System.out.println("End..........");
	}
}
