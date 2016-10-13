package com.neu.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.neu.dao.pojo.User;
import com.neu.service.IUserService;
import com.neu.service.UserServiceImpl;

public class UserServiceImplTest {
	
	IUserService userService;
	
	@Before
	public void setUp() throws Exception {
		userService = new UserServiceImpl();
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setId(1);
		System.out.println(userService.save(user));
		
		user.setId(10);
		user.setUsername("汉武帝");
		user.setPassword("123");
		System.out.println(userService.save(user));
		
	}

	@Test
	public void testDelete() {
		User user = new User();
		user.setId(100);
		System.out.println(userService.delete(user));
		
		user.setId(6);
		System.out.println(userService.delete(user));
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(100);
		System.out.println(userService.update(user));
		
		user.setId(5);
		user.setUsername("TTTT");
		user.setPassword("123");
		System.out.println(userService.update(user));
	}

	@Test
	public void testFindAll() {
		System.out.println(userService.findAll());
	}

	@Test
	public void testFindByName() {
		System.out.println(userService.findByName("o"));
	
	}

	@Test
	public void testFindById() {
		System.out.println(userService.findById(2));
		
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

}
