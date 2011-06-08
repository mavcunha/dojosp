package com.tw.dojosp.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.tw.dojosp.dao.UserDAO;

public class ReportService {

	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Map<Integer, String> findUsers(String name) {
		if(connection == null)
			throw new IllegalStateException("Connection is null");
		
		return new UserDAO(connection).findByName(name);
	}

	public List<String> findDevices(Integer userId) {
		if(connection == null)
			throw new IllegalStateException("Connection is null");
		
		return new UserDAO(connection).findDevices(userId);
	}

}
