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
    <style type="text/css">body{
        background-color:#E0EEE0;
        text-align:center;
        font-family:"Arial"
    }
    </style>

  </head>
  
  <body>
    <br>
    <h2>Your Account</h2>
    <br><br>
    <%String username = (String)session.getAttribute("username"); 
    	SUserDAOImpl user = new SUserDAOImpl();
    		
    		User u = user.getUserInfo(username);
    
    %>
    
    <h4>Name: <%=u.getUsername() %></h4><br>
    <h4>E-mail address: <%=u.getEmailAddress() %> </h4><br>
    
    <input type="button" name="changepwd" value="Change Password" onclick="window.location.href='./changeP'"/>
    <br><br>
    
    <input type="button" name="homepage" value="Homepage" onclick="window.location.href='./WelcomeUser'"/>
    <br><br>
    
    <form method="get" action="userlogout">
    <input type="submit" value="Logout">
    </form>
  </body>
</html>
