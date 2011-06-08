package com.tw.dojosp.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.dojosp.model.Prod;

public class ProdDAOTest {
	
	private Connection connection;
	private ProdDAO prodDAO;

	@Before
	public void setUp() {
		connection = new InMemoryDatabase().getConnection();
		prodDAO = new ProdDAO(connection);
	}
	
	@Test
	public void shouldFindAProdGivenAnId() {
		Prod foundProd = prodDAO.findById(1);
		Prod expectedProd = new Prod(1,"iPod",200);
		assertEquals(expectedProd, foundProd);
	}
	
	@After
	public void tearDown() throws SQLException {
		connection.close();
	}
	

}
