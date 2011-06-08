package com.tw.dojosp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tw.dojosp.model.Prod;
import com.tw.dojosp.model.User;

public class ProdDAO {

	private Connection connection;

	public ProdDAO(Connection connection) {
		this.connection = connection;
	}

	public Prod findById(int id) {
		PreparedStatement statement = null;
		Prod prod = null;
		try {
			statement = connection
					.prepareStatement("SELECT ID, DESC, PRICE FROM PRODS WHERE ID=?");

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				prod = new Prod(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;
	}
}
