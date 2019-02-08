package jspServlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;

import jspServlet.dao.UserDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.User;

public class RUserDAOImpl implements UserDAO{
	
	public int queryByUsername(User user) throws Exception{
		int flag = 0;
		String sql = "select * from user_info where useremail=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		try {
			dbc = new DBConnect();
			System.out.println(dbc);
			
			pstmt = dbc.getConnection().prepareStatement(sql);
			if(pstmt==null) {System.out.println("null pointer!!!!!!");}
			
			pstmt.setString(1,user.getEmailAddress());
			
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				flag = 0;
			}else {flag = 1;}
			
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		
		return flag;
	}

}
