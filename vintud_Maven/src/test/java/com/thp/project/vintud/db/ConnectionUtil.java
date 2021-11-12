package com.thp.project.vintud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	    private static ConnectionUtil instance;
	    private Connection connection;
	    private String url = "jdbc:postgresql://localhost:5432/vintud";
	    private static String driverName = "org.postgresql.Driver";
	    private String username = "postgres";
	    private String password = "root";

	    public ConnectionUtil() throws SQLException {
	        try {
	            Class.forName(driverName);
	            this.connection = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	        }
	    }

	    public Connection getConnection() {
	        return connection;
	    }

	    public static ConnectionUtil getInstance() throws SQLException {
	        if (instance == null) {
	         
	        	instance = new ConnectionUtil();
	     
	        } else if (instance.getConnection().isClosed())
	        	instance = new ConnectionUtil();

	        return instance;
	    }

}
