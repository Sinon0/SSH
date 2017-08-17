package com.wy.service;

import org.hibernate.Session;

import com.wy.common.HibernateUtils;
import com.wy.dao.UserDAO;
import com.wy.entity.User;

public class UserDaoImpl implements UserDAO {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.openSession();
		session.beginTransaction();
		session.merge(user);
		session.getTransaction().commit();
		session.close();
	}

}
