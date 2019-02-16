package jspServlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jspServlet.dao.CUserDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.User;

public class CUserDAOImpl implements CUserDAO{
	public int changePwd(User user)throws Exception{
		int flag = 0;
		String sql = "UPDATE user_info SET password='"+user.getPassword()+"' WHERE useremail='"+user.getEmailAddress()+"';";
		PreparedStatement pstmt = null;
		
		
		try {
			DBConnect dbc = null;
			dbc = new DBConnect();
			
			Connection conn = dbc.getConnection();
			
			System.out.println(dbc);
			
			Statement statement = conn.createStatement();
			
			flag = statement.executeUpdate(sql);
			
			statement.close();
			
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	

}
