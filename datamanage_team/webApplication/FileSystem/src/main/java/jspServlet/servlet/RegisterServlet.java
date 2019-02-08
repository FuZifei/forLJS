package jspServlet.servlet;

import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jspServlet.dao.impl.*;


import jspServlet.db.DBConnect;

import jspServlet.vo.User;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		
	};
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		User user = new User();
		
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setEmailAddress(req.getParameter("useremail"));
		
		String rusername = user.getUsername();
		String rpassword = user.getPassword();
		String remail = user.getEmailAddress();
		System.out.println("CHECK USER INFO");
		System.out.println(rusername);
		System.out.println(rpassword);
		System.out.println(remail);
		//System.out.println(rpassword);
		
		RUserDAOImpl dao = new RUserDAOImpl();
		int flag=0;
		
		try {
			flag = dao.queryByUsername(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(flag==1) {
			try {
				String sql = "INSERT INTO user_info(useremail,username,userimg,password)"+"VALUES("+"'"+remail+"','"+rusername+"','123','"+rpassword+"');";
				DBConnect dbc = new DBConnect();
				Connection conn = dbc.getConnection();
				
				System.out.println(dbc);
				
				Statement statement = conn.createStatement();
				
				statement.executeUpdate(sql);
				
				statement.close();
				
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("username",user.getUsername());
			res.sendRedirect("./userinformation.jsp");
		}
		else {res.sendRedirect("./Rerror.jsp");}
	};

}
