package com.neu.test;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.neu.dao.util.SessionFactory;

public class SessionFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSession() throws Exception {
		Connection con = SessionFactory.newInstance().getSession();
		System.out.println(con);
	}

}
