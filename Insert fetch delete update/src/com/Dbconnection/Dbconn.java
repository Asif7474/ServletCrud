package com.Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconn {

	public static Connection conn=null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","admin");
			System.out.println("connection success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	} 
}
