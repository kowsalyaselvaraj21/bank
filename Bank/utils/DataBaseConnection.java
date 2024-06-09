package com.techymeet.jdbcproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	
	public static Connection createConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

}
