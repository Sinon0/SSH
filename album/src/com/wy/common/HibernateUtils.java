package com.wy.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory(){
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    
	    ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
	    		.applySettings(configuration.getProperties()).build();
	    
	    SessionFactory sessionFactory=configuration
	    		.buildSessionFactory(serviceRegistry);
			
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null)
			sessionFactory=buildSessionFactory();
			return sessionFactory;
	}
	
	public static Session openSession(){
		return getSessionFactory().openSession();
	}
}
