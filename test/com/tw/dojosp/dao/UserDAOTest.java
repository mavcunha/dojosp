package com.tw.dojosp.dao;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.dojosp.InMemoryDatabase;

public class UserDAOTest {
	
	private Connection connection;
	private UserDAO userDAO;

	@Before
	public void getAConnection() {
		connection = new InMemoryDatabase().getConnection();
		userDAO = new UserDAO(connection);
	}
	
	@Test
	public void shouldFindAUser() {
		Map<Integer, String> expected = new HashMap<Integer, String>();
		expected.put(1, "Marco");
		
		Map<Integer, String> results = userDAO.findByName("Marco");
		
		assertEquals(expected, results);
	}
	
	@Test
	public void shouldListDevicesGivenAUserId() {
		List<String> expected = new ArrayList<String>();
		expected.add("iPod Nano");
		expected.add("iPhone 4");
		
		List<String> results = userDAO.findDevices(1);
		
		assertEquals(expected, results);
	}
	
	@After
	public void cleanUp() throws SQLException {
		connection.close();
	}
}
