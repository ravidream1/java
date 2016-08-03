package com.amol.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amol.bean.Login;
import com.amol.dao.LoginDao;
import com.amol.util.DBConnection;

public class LoginDaoImpl implements LoginDao{
	
	public static final String SELECT_LOGIN_SQL = "select username, password from login where username = ? and password = ?";
	DBConnection dbConnection= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	Connection con= null;
	
	@Override
	public boolean login(Login login) {
		boolean result = false;
		dbConnection = new DBConnection();

		try {
			con = dbConnection.getConnection();
			ps = con.prepareStatement(SELECT_LOGIN_SQL);
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			rs = ps.executeQuery();			

			while(rs.next()){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				dbConnection.close(con);
			}
			if (ps != null) {
				dbConnection.close(ps);
			}
			if (rs != null) {
				dbConnection.close(rs);
			}
		}//END OF FINALLY
		
		return result;

	}
}//end of the class
