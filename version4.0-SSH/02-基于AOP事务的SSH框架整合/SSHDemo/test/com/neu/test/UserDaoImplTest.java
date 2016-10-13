package com.neu.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neu.dao.idao.UserDao;
import com.neu.dao.pojo.User;

public class UserDaoImplTest {
	UserDao userDao;

	@Before
	public void setUp() throws Exception {
		userDao = (UserDao) 
				new ClassPathXmlApplicationContext("applicationContext.xml")
				.getBean("userDao");
	}

	@Test
	public void testSave() throws Exception {
		User user = new User("admin","123",new Date());
		userDao.save(user);
	}

	@Test
	public void testDelete() throws Exception {
		User user = new User();
		user.setId(3);
		userDao.delete(user);
	}

	@Test
	public void testUpdate() throws Exception {
		User user = userDao.findById(2);//注意:此时的User是游离状态
		user.setPassword("tiger");
		userDao.update(user);//将一个游离状态的对象变更为持久化状态,实现数据信息的同步更改		
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
		List<User> users = userDao.findByName("ad");
		for(User user:users){
			System.out.println(user);
		}
	}

	@Test
	public void testFindById() throws Exception {
		User user = (User)userDao.findById(2);
		//当执行完findById后,session关闭,
		//此时的user,具有oid,但不在session缓存中,所以是游离状态detached
		System.out.println(user);
	}

	@Test
	public void testLogin() throws Exception {
		User user = new User();
		user.setUsername("root1");
		user.setPassword("root");
		System.out.println(userDao.login(user));
	}

}
