package com.tw.dojosp.dao;

import java.sql.Connection;

public class ProdDAO {

	private Connection connection;

	public ProdDAO(Connection connection) {
		this.connection = connection;
	}

}
