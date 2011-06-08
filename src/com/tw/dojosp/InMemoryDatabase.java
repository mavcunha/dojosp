package com.tw.dojosp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InMemoryDatabase {

	private Connection connection;

	public InMemoryDatabase() {
		try {
			connect();
			createUsersTable();
			createDevicesTable();
			createUserDeviceTable();
			
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

	private void createDevicesTable() throws SQLException {
		connection.prepareStatement(
				"CREATE TABLE DEVICES(ID INT PRIMARY KEY, DESC VARCHAR(255)) AS "
						+ "  SELECT * FROM CSVREAD('data/devices_data.csv');")
				.execute();
	}

	private void createUserDeviceTable() throws SQLException {
		connection.prepareStatement(
				"CREATE TABLE USER_DEVICE(USER_ID INT, DEV_ID INT) AS "
						+ "  SELECT * FROM CSVREAD('data/user_device_data.csv');")
				.execute();
	}
}
