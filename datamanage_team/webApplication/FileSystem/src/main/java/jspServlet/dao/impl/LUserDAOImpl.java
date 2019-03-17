package jspServlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;

import jspServlet.dao.UserDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.User;


public class LUserDAOImpl implements UserDAO{
	
	public int queryByUsername(User user)throws Exception{
		int flag = 0;
		String sql = "SELECT * FROM user_info where useremail=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		//System.out.println(user.getEmailAddress()+"HELLO");
		
		try {
			dbc = new DBConnect();
			//System.out.println("step 2.1");
			//System.out.println(dbc);
			try {
				pstmt = dbc.getConnection().prepareStatement(sql);
				//System.out.println("step 2.2");
				//System.out.println(pstmt);
				if(pstmt==null) {System.out.println("null pointer!!!!!!");}
				pstmt.setString(1,user.getEmailAddress());
				
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					//System.out.println(rs);
					if(rs.getString("password").contentEquals(user.getPassword())){
						flag = 1;
						user.setUsername(rs.getString("username"));
					}
				}
				rs.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}finally {	
				pstmt.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return flag;
	}
	

}
