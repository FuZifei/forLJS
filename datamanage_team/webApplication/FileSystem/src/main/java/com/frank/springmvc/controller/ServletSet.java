package com.frank.springmvc.controller;

import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jspServlet.dao.UserDAO;
import jspServlet.dao.impl.CUserDAOImpl;
import jspServlet.dao.impl.LUserDAOImpl;
import jspServlet.dao.impl.RUserDAOImpl;
import jspServlet.db.DBConnect;
import jspServlet.vo.User;


@Controller
public class ServletSet {

	//Login
	@RequestMapping("/userlogin")
	public String loginServlet(HttpServletRequest req) {
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
			return "userinformation";
		}
		else{
			//System.out.println("step 3");
			//System.out.println(flag);
			return "error";
		}
	}
	
	
	//Rgister
	@RequestMapping("/userregister")
	public String registerServlet(HttpServletRequest req) {
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
			return "userinformation";
		}
		else {return "Rerror";}
	}
	
	
	//Logout
		@RequestMapping("/userlogout")
		public String logoutServlet(HttpServletRequest req) {
			req.getSession().invalidate();
			return "Welcome";
		}
		
		
	//Change password
		@RequestMapping("/changePassword")
		public String changePwdServlet(HttpServletRequest req) {
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
				return "changeError1";
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
					return "changeError2";
				}
				else {
					return "changeSuccess";
				}
				
			}
			
		}
}
