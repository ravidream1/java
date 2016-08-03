package com.amol.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * @author Ravi Thapa
 *
 */
public class DBConnection {
	public DBConnection(){
		System.setProperty("JDBC_CONNECTION_STRING", "jdbc:mysql://localhost:3306/shool_db");
		System.setProperty("RDS_USERNAME", "root");
		System.setProperty("RDS_PASSWORD", "mysql");
	}

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static String JDBC_CONNECTION_STRING=""; 	
	static String USER = "";
	static String PASS = "";

	public Connection getConnection() {
		JDBC_CONNECTION_STRING = System.getProperty("JDBC_CONNECTION_STRING");
		USER = System.getProperty("RDS_USERNAME");
		PASS = System.getProperty("RDS_PASSWORD");
		Connection connection = null;
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_CONNECTION_STRING, USER, PASS);
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}


	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection connection) {
		try {
			if (connection != null) {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection con) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}
	}
}
