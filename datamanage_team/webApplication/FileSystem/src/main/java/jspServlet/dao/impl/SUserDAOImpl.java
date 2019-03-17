package jspServlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspServlet.dao.SUserDAO;
import jspServlet.db.DBConnect;
import jspServlet.vo.User;

public class SUserDAOImpl implements SUserDAO{
	public List<User> userInfo(){
		List<User> userList = new ArrayList<User>();
		
		try {
			DBConnect db= new DBConnect();
			Connection connection = db.getConnection();
			
			PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM user_info");
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				User user = new User();
				user.setUsername(resultSet.getString(3));
				user.setPassword(resultSet.getString(5));
				user.setEmailAddress(resultSet.getString(2));
				
				userList.add(user);
			}
			resultSet.close();
			pStatement.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public User getUserInfo(String username) {
		User user1 = new User();
		
		try {
			DBConnect db = new DBConnect();
            Connection connection = db.getConnection();
            PreparedStatement pStatement = connection.prepareStatement("select * from USER_INFO where username=?");
            pStatement.setString(1, username);
            ResultSet resultSet = pStatement.executeQuery();
            
            while(resultSet.next()){
            	user1.setUsername(resultSet.getString(3));
				user1.setPassword(resultSet.getString(5));
				user1.setEmailAddress(resultSet.getString(2));
            }
            resultSet.close();
            pStatement.close();
            connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user1;
	}

}
