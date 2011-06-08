package com.tw.dojosp.dao;

import java.sql.Connection;

import org.junit.Before;

public class ProdDAOTest {
	
	private Connection connection;
	private ProdDAO prodDAO;

	@Before
	public void setUp() {
		connection = new InMemoryDatabase().getConnection();
		prodDAO = new ProdDAO(connection);
	}

}
