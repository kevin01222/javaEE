package com.neu.service;

import java.util.List;

import com.neu.dao.idao.IUserDao;
import com.neu.dao.impl.UserDao;
import com.neu.dao.pojo.User;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDao();
	}

	@Override
	public String save(User user) {
		String msg = "error";
		try {
			if (userDao.findById(user.getId()) == null) {
				userDao.save(user);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String delete(User user) {
		String msg = "error";
		try {
			if (userDao.findById(user.getId()) != null) {
				userDao.delete(user);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String update(User user) {
		String msg = "error";
		try {
			if (userDao.findById(user.getId()) != null) {
				userDao.update(user);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<User> findAll() {
		List<User> users = null;
		try {
			users = userDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<User> findByName(String username) {
		List<User> users = null;
		try {
			users = userDao.findByName(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findById(int id) {
		User user = null;
		try {
			user = userDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean login(User user) {
		boolean flag = false;
		try {
			flag = userDao.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
