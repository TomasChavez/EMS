package com.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoUtilities {

	private static final String CONNECTION_USERNAME = "testUser";
	private static final String CONNECTION_PASSWORD = "Myexampledatabase!";
	private static final String URL = "jdbc:mysql://localhost:3306/ems";
	//"root", "Mydat@base!2020")
	private static DepartmentDaoImpl departmentDaoImpl;
	//added
	private static EmployeeDaoImpl employeeDaoImpl;
	
	private static Connection connection;
	

	public static synchronized DepartmentDao getDepartmentDao() {

		if (departmentDaoImpl == null) {
			departmentDaoImpl = new DepartmentDaoImpl();
		}
		return departmentDaoImpl;
	}
	public static synchronized EmployeeDao getEmployeeDao() {
		if(employeeDaoImpl == null) {
			employeeDaoImpl = new EmployeeDaoImpl();
		}
		return employeeDaoImpl;
	}

	static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("getting new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}

}
