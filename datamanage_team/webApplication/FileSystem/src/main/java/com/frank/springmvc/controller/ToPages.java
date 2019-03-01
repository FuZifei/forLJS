package com.frank.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToPages {
	
	//turn to uploadfile.jsp
	@RequestMapping("/uploadfile")
	public String react() {
		System.out.print("succeed");
		return "uploadfile";
	}
	
	//turn to Welcome.jsp
	@RequestMapping("/Welcome")
	public String welcomepage() {
		return "Welcome";
	}
	
	//turn to login.jsp
	@RequestMapping("/loginpage")
	public String loginpage() {
		System.out.print("login loading");
		return "login";
	}
	
	//turn to login.jsp
	@RequestMapping("/registerpage")
	public String registerpage() {
			System.out.print("register loading");
			return "register";
		}
/*	
	//turn to FilePage.jsp
	@RequestMapping("/FilePage")
	public String filePage() {
		return "FilePage";
	}
*/
	
	//turn to WelcomeUser.jsp
	@RequestMapping("/WelcomeUser")
	public String welcomeUserpage() {
		return "WelcomeUser";
	}

	//turn to userinformation.jsp
	@RequestMapping("/userinformation")
	public String userinformationPage() {
		return "userinformation";
	}
	
	//turn to changePwd.jsp
	@RequestMapping("/changeP")
	public String changePwdPage() {
		return "changePwd";
	}
	
	//turn to changeError1.jsp
	@RequestMapping("/changeError1")
	public String changeError1Page() {
		return "changeError1";
	}
	
	//turn to changeError2.jsp
	@RequestMapping("/changeError2")
	public String changeError2Page() {
		return "changeError2";
	}
	
	
}
