package com.neu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.neu.dao.idao.IUserDao;
import com.neu.dao.pojo.User;
import com.neu.dao.util.HibernateSessionFactory;

public class UserDao implements IUserDao {

	@Override
	public void save(User user) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
//		session.close();
	}

	@Override
	public void delete(User user) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
//		session.close();
	}

	@Override
	public void update(User user) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();
//		session.close();
	}

	@Override
	public List<User> findAll() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		transaction.commit();
//		session.close();
		return users;

	}

	@Override
	public List<User> findByName(String username) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User u where u.username like ?");
		query.setParameter(0, "%"+username+"%");
		List<User> users = query.list();
		transaction.commit();
//		session.close();
		return users;
	}

	@Override
	public User findById(int id) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		transaction.commit();
//		session.close();
		return user;
	}

	@Override
	public boolean login(User user) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User u where u.username=? and u.password=?");
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		User user1 = (User) query.uniqueResult();
		transaction.commit();
//		session.close();
		return user1 == null ? false : true;
	}

}
