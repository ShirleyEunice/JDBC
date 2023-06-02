package com.wiley.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	static Connection conn;
	
	public static Connection createDBConnection() {
		try {
            String driver="com.mysql.cj.jdbc.Driver";
    		Class.forName(driver);
    		//connection string
    		String url="jdbc:mysql://localhost:3306/wileyjdbc";
    		String username="root";
    		String password="1Shirleyjustin4@";
    		
 
            conn=DriverManager.getConnection(url,username,password);
    		
       		System.out.println("Connection Success");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
