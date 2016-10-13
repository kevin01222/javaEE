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
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void delete(User user) throws Exception {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void update(User user) throws Exception {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public List<User> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from User").list();

	}

	@Override
	public List<User> findByName(String username) throws Exception {
		return sessionFactory.getCurrentSession()
				.createQuery("from User u where u.username like ?")
				.setParameter(0, "%" + username + "%").list();
	}

	/*findById目前的代码不符合删除和修改的需要,原因,
	 * @Transactional注解只能在由外向内访问时实现AOP事务机制,对于delete方法
	 * 和update方法,它们是从内部对findById进行访问,那么Session不会关闭,
	 * 而只是把findById的对象放入到session缓存中,导致
	 * 删除和修改操作出现错误:a different object with the same identifier value
	 * 解决方案1:
	 * 	if(user != null){
	 * 	session.evict(user);
	 * 	}
	 * 解决方案2:在return之前,调用session.clear()
	 * 但前两个解决方案,都只能解决delete和update操作,
	 * 却无法解决save操作中的findById方法的session关闭问题
	 * 所以,终极解决方案3:如下
	*/
	@Override
	public User findById(int id) throws Exception {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;

	}

	@Override
	public boolean login(User user) throws Exception {
		User user1 = (User) sessionFactory.getCurrentSession()
				.createQuery("from User u where u.username=? and u.password=?")
				.setParameter(0, user.getUsername())
				.setParameter(1, user.getPassword()).uniqueResult();
		return user1 == null ? false : true;
	}

}
