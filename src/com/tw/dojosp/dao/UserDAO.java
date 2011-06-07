package com.tw.dojosp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tw.dojosp.model.User;

public class UserDAO {

	private Connection connection;

	public UserDAO(Connection connection) {
		this.connection = connection;
	}

	public User findById(int id) {
		PreparedStatement statement = null;
		User user = null;
		try {
			statement = connection.prepareStatement("SELECT ID, NAME FROM USERS WHERE ID=?");
			
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1),resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
