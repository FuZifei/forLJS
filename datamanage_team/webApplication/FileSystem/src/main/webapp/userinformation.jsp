<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
 <%@ page import="jspServlet.dao.impl.SUserDAOImpl,jspServlet.vo.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>User Information</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		body{text-align:center; font-family:"Arial"}
		
	</style>

  </head>
  
  <body bgcolor="#E0EEE0">
    <br>
    <h2>Your Account</h2>
    <br><br>
    <%String username = (String)session.getAttribute("username"); 
    	SUserDAOImpl user = new SUserDAOImpl();
    		
    		User u = user.getUserInfo(username);
    
    %>
    
    <h4>Name: <%=u.getUsername() %></h4><br>
    <h4>E-mail address: <%=u.getEmailAddress() %> </h4><br>
    <a href="changePwd.jsp?param=<%=username %>"><b>Change your password</b></a>
    <br>
    <a href="WelcomeUser.jsp?param=<%=username %>"><b>Go to the Home Page</b></a>
  </body>
</html>
