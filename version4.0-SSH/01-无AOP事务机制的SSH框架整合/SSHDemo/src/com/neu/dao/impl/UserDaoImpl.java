package com.neu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.neu.dao.idao.UserDao;
import com.neu.dao.pojo.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

	@Override
	public void delete(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
	}

	@Override
	public void update(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
	}

	@Override
	public List<User> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		transaction.commit();
		return users;

	}

	@Override
	public List<User> findByName(String username) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User u where u.username like ?");
		query.setParameter(0, "%"+username+"%");
		List<User> users = query.list();
		transaction.commit();
		return users;
	}

	@Override
	public User findById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		transaction.commit();
		return user;
	}

	@Override
	public boolean login(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery("from User u where u.username=? and u.password=?");
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		User user1 = (User) query.uniqueResult();
		transaction.commit();
		return user1 == null ? false : true;
	}

}
