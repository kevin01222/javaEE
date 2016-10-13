package com.neu.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SessionFactory {

	private static SessionFactory sessionFactory = new SessionFactory();
	private ComboPooledDataSource cpds = null;

	private SessionFactory() {
		cpds = new ComboPooledDataSource("java9");
	}

	public static SessionFactory newInstance() {
		return sessionFactory;
	}

	public Connection getSession() throws Exception {
		return cpds.getConnection();
	}

	public void close(ResultSet rs, Statement ps, Connection con) throws Exception {
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (con != null)
			con.close();
	}

}
