package com.neu.dao.idao;

import java.util.List;

import com.neu.dao.pojo.User;

public interface UserDao {
	void save(User user) throws Exception;

	void delete(User user) throws Exception;

	void update(User user) throws Exception;

	List<User> findAll() throws Exception;

	List<User> findByName(String username) throws Exception;

	User findById(int id) throws Exception;

	boolean login(User user) throws Exception;
}
