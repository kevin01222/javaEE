package com.neu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neu.dao.idao.IUserDao;
import com.neu.dao.pojo.User;
import com.neu.dao.util.SessionFactory;

public class UserDaoImpl implements IUserDao {

	@Override
	public void save(User user) throws Exception {
		Connection con = SessionFactory.newInstance().getSession();
		String sql = "insert into t_user(username,password,regtime) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getRegtime());
		ps.executeUpdate();
		SessionFactory.newInstance().close(null, ps, con);
	}

	@Override
	public void delete(User user) throws Exception {
		Connection con = SessionFactory.newInstance().getSession();
		String sql = "delete from t_user where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, user.getId());
		ps.executeUpdate();
		SessionFactory.newInstance().close(null, ps, con);
	}

	@Override
	public void update(User user) throws Exception {
		Connection con = SessionFactory.newInstance().getSession();
		String sql = "update t_user set username=?,password=?,regtime=? where id=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getRegtime());
		ps.setInt(4, user.getId());
		ps.executeUpdate();
		SessionFactory.newInstance().close(null, ps, con);
	}

	@Override
	public List<User> findAll() throws Exception {
		Connection con = SessionFactory.newInstance().getSession();
		String sql = "select id,username,password,regtime from t_user ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		SessionFactory.newInstance().close(rs, ps, con);
		return users;
	}

	@Override
	public List<User> findByName(String username) throws Exception {
		Connection con = SessionFactory.newInstance().getSession();
		String sql = "select id,username,password,regtime from t_user where username like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + username + "%");
		ResultSet rs = ps.executeQuery();
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		SessionFactory.newInstance().close(rs, ps, con);
		return users;
	}

	@Override
	public User findById(int id) throws Exception {
		Connection con = SessionFactory.newInstance().getSession();
		String sql = "select id,username,password,regtime from t_user where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		SessionFactory.newInstance().close(rs, ps, con);
		return user;
	}

	@Override
	public boolean login(User user) throws Exception {
		boolean flag = false;
		Connection con = SessionFactory.newInstance().getSession();
		String sql = "select id from t_user where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			flag = true;
		}
		SessionFactory.newInstance().close(rs, ps, con);
		return flag;
	}

}
