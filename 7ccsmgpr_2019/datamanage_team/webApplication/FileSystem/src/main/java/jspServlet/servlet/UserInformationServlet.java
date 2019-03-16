package jspServlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jspServlet.vo.User;

public class UserInformationServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
		User user = new User();
		
		user.setUsername(req.getParameter("user"));
		
	}
	

}
