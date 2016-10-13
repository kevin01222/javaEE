package com.neu.dao.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {

	private static Configuration configuration = new Configuration();
	private static ServiceRegistry serviceRegistry;
	private static org.hibernate.SessionFactory sessionFactory;
	
	//静态块实现对静态数据的初始化
	static {
		try {
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	private HibernateSessionFactory() {
	}
	
	//根据SessionFactory获取Session数据库连接
	public static Session getSession() throws HibernateException {
			return sessionFactory.getCurrentSession();//绑定线程,自动关闭
	}

	public static void main(String[] args) {
		System.out.println(HibernateSessionFactory.getSession().toString());
	}
	
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Configuration getConfiguration() {
		return configuration;
	}
	
}