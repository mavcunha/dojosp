package com.tw.dojosp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.dojosp.model.User;

public class UserDAOTest {
	
	private Connection connection;
	private UserDAO userDAO;

	@Before
	public void getAConnection() {
		connection = new InMemoryDatabase().getConnection();
		userDAO = new UserDAO(connection);
	}
	
	@Test
	public void shouldFindAUserGivenAId() {
		
		User expectedUser = new User(1,"marco");
		User foundUser    = userDAO.findById(1);
		
		assertEquals(expectedUser, foundUser);
	}
	
	@Test
	public void shouldReturnNullIfUserNotFoundById() {
		assertNull(userDAO.findById(999));
	}
	
	@Test
	public void shouldPopulateUserFound() {
		User expectedUser = new User(1,"marco");
		assertEquals(expectedUser.name(), userDAO.findById(1).name());
	}
	
	@After
	public void cleanUp() throws SQLException {
		connection.close();
	}
}
