package com.tw.dojosp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InMemoryDatabase {

	private Connection connection;

	public InMemoryDatabase() {
		try {
			connect();
			createUsersTable();
			createProdsTable();
			createOrdersTable();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}

	private void connect() throws SQLException, ClassNotFoundException {
		connection = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");
	}

	private void createUsersTable() throws SQLException {
		connection.prepareStatement(
				"CREATE TABLE USERS(ID INT PRIMARY KEY, NAME VARCHAR(255)) AS "
						+ "  SELECT * FROM CSVREAD('data/users_data.csv');")
				.execute();
	}

	private void createProdsTable() throws SQLException {
		connection.prepareStatement(
				"CREATE TABLE PRODS(ID INT PRIMARY KEY, DESC VARCHAR(255), PRICE INT) AS "
						+ "  SELECT * FROM CSVREAD('data/prods_data.csv');")
				.execute();
	}

	private void createOrdersTable() throws SQLException {
		connection.prepareStatement(
				"CREATE TABLE ORDERS(USER_ID INT, PROD_ID INT, QUANTITY INT) AS "
						+ "  SELECT * FROM CSVREAD('data/orders_data.csv');")
				.execute();
	}
}
