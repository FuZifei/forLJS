<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Change password page</title>
    
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
    
    <form method="post" action="changePassword">
    	<p><h2>Please enter your email:</h2></p>
    	<input type="text" name="useremail"><br>
    	<p><h2>Please confirm your password:</h2></p><br>
    	<input type="password" name="oripassword"/><br>
    	<h2>Please enter your new password:</h2><br>
    	<p>new password: <input type="password" name="newpassword"/></p><br>
    	<p>confirm password: <input type="password" name="cnewpassword"/></p><br>
    	<input type="submit" name="submit" value="submit"><br>
    </form>
    
  </body>
</html>
