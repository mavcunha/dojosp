package com.tw.dojosp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2.tools.Server;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class MemoryDatabase {
	
	private static Server server;
	private static Connection connection;

	@BeforeClass
	public static void startServer() throws SQLException, ClassNotFoundException {
		server = Server.createTcpServer(new String[]{"-tcpAllowOthers"}).start();
		 Class.forName("org.h2.Driver");
	     connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	     
	     createTableDataFrom("data/employees_data.csv").execute();
	}

	private static PreparedStatement createTableDataFrom(String csvData) throws SQLException {
		PreparedStatement prepareStatement = connection.prepareStatement(
	     		"CREATE TABLE EMPLOYEES(ID INT PRIMARY KEY, NAME VARCHAR(255)) AS " +
	     		"  SELECT * FROM CSVREAD('"+csvData+"');");
		return prepareStatement;
	}
	
	@AfterClass
	public static void stopServer() throws SQLException {
		server.stop();
	}
	

}
