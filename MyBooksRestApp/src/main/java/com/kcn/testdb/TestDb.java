package com.kcn.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDb {

	public static void main(String args[]) {
		
		String jdbcurl = "jdbc:mysql://localhost:3306/libdb?useSSL=false";
		String username = "libDB";
		String pwd = "libDB";
		
		try {
			
			System.out.println("Testing connection");
			
			Connection myCon = DriverManager.getConnection(jdbcurl, username, pwd);
			
			System.out.println("Connection successful");
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}