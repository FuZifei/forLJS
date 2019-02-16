package jspServlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspServlet.dao.UserDAO;
import jspServlet.dao.impl.LUserDAOImpl;
import jspServlet.vo.User;


public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
		User user = new User();
		user.setEmailAddress(req.getParameter("useremail"));
		
		user.setPassword(req.getParameter("password"));
		//System.out.println(user.getUsername());
		//System.out.println("CHECK");
		
		UserDAO dao = new LUserDAOImpl();
		
		int flag = 0;
		//System.out.println("step 1");
		//System.out.println(flag);
		try {
			flag = dao.queryByUsername(user);
			//System.out.println("step 2");
			//System.out.println(flag);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(flag==1) {
			HttpSession session=req.getSession();
			session.setAttribute("username", user.getUsername());
			
			//edit
			res.sendRedirect("./userinformation.jsp");
		}
		else{
			//System.out.println("step 3");
			//System.out.println(flag);
			res.sendRedirect("./error.jsp");
		}
	}

}
