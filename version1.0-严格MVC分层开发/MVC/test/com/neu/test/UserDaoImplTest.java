package com.neu.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.neu.dao.idao.IUserDao;
import com.neu.dao.impl.UserDaoImpl;
import com.neu.dao.pojo.User;

public class UserDaoImplTest {
	
	private IUserDao userDao;
	
	@Before
	public void setUp() throws Exception {
		userDao = new UserDaoImpl();
	}

	@Test
	public void testSave() throws Exception {
		User user = new User("user001","tiger123","2016-01-01");
		userDao.save(user);
	}

	@Test
	public void testDelete() throws Exception {
		User user = new User();
		user.setId(4);
		userDao.delete(user);
	}

	@Test
	public void testUpdate() throws Exception {
		User user = userDao.findById(5);
		System.out.println("data:"+user);
		user.setUsername("qinshihuang");
		userDao.update(user);		
	}

	@Test
	public void testFindAll() throws Exception {
		List<User> users = userDao.findAll();
		for(User user:users){
			System.out.println(user);
		}
	}

	@Test
	public void testFindByName() throws Exception {
		System.out.println(userDao.findByName("o"));
	}

	@Test
	public void testFindById() throws Exception {
		System.out.println(userDao.findById(5));
	}

	@Test
	public void testLogin() throws Exception {
		User user = new User();
		user.setUsername("root");
		user.setPassword("root");
		System.out.println(userDao.login(user));
	}

}
