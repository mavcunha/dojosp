package com.tw.dojosp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {

	private Connection connection;

	public UserDAO(Connection connection) {
		this.connection = connection;
	}

	public Map<Integer, String> findByName(String name) {
		
		Map<Integer, String> results = new HashMap<Integer, String>();
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("SELECT ID, NAME FROM USERS WHERE NAME LIKE ? ");
			
			statement.setString(1, '%' + name + '%');
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				results.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public List<String> findDevices(Integer userId) {
		List<String> results = new ArrayList<String>();
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(
					"SELECT D.DESC FROM DEVICES D JOIN USER_DEVICE UD ON(D.ID = UD.DEV_ID)" +
					" WHERE UD.USER_ID = ? "
			);
			
			statement.setInt(1, userId);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				results.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

}
