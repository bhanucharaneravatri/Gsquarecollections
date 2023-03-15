/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.Factory;

/**
 *
 * @author charanbhanu4
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// static reference to itself
	private static ConnectionFactory instance = new ConnectionFactory();

	String url = "jdbc:mysql://localhost:3306/CarRental";
	String user = "root";
	String password = "root";
	String driverClass = "com.mysql.jdbc.Driver";

	// private constructor
	private ConnectionFactory()
	{
		try {
			Class.forName(driverClass);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance()
	{
		return instance;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}

