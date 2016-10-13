package com.neu.test;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSessionFactory {
	ApplicationContext ctx;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	// 1-测试IOC容器提供的dataSource数据源对象
	@Test
	public void testDataSource() {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}

	// 2-测试SessionFactory对象
	@Test
	public void testSessionFactory() {
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		//复习:getCurrentSession可以自动关闭Session(必须有事务提交或者回滚时才出发关闭操作),
		//但所有操作必须有事务机制
		System.out.println(session);
	}
}
