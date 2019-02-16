package jspServlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspServlet.dao.*;
import jspServlet.dao.impl.*;
import jspServlet.vo.User;

public class ChangePwdServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
		
		//part of login servlet to check whether the old password is correct
		User user = new User();
		user.setEmailAddress(req.getParameter("useremail"));
		
		user.setPassword(req.getParameter("oripassword"));
		System.out.println(user.getUsername());
		System.out.println("CHECK");
		
		UserDAO dao = new LUserDAOImpl();
		
		int flag = 0;
		System.out.println("step 1");
		System.out.println(flag);
		try {
			flag = dao.queryByUsername(user);
			System.out.println("step 2");
			System.out.println(flag);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(flag==0) {
			//the wrong password
			res.sendRedirect("./changeError1.jsp");
		}
		else{
			user.setPassword(req.getParameter("newpassword"));
			CUserDAOImpl cdao = new CUserDAOImpl();
			try {
				flag = cdao.changePwd(user);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if(flag==0) {
				res.sendRedirect("./changeError2.jsp");
			}
			else {
				res.sendRedirect("./changeSuccess.jsp");
			}
			
		}
		
		
	}

}
