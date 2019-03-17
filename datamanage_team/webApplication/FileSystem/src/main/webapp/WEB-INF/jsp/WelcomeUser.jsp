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
    
    <title>My JSP 'WelcomeUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
   body{
    background-color:#E0EEE0;
    text-align:center;
    font-family:"Arial"

    .wudiv-left{float:left; background:"#008B8B";width:100%; height:25%;display:flex; justify-content:center; aligh-items:center;}
	.wui{text-align:center; width:100%;height:22%; display:flex; justify-content:center; aligh-items:center;}

</style>

  </head>
  
  <body>
    
    <% String username = (String)session.getAttribute("username");%>
    <div class="wudiv-left">
    <h1><font color="white">Welcome, <%= username %></font></h1>
    </div>
    
    <div class="wui">
    
    <nav>
	<a href="./uploadfile">File</a> |
	<a href="">Photo</a> |
	<a href="">Video</a> |
	<a href="">Music</a>|
	<a href="">Backup</a>|
	<a href="./userinformation">User Account</a>
	</nav>
	</div>
	
	<div class="wui">
	<br><br><br>
	<h4>Communication</h4>
	</div>
	
	<br>
	<div class="wui">
	<nav>
	<a href="">Add</a> |
	<a href="">Share</a> |
	<a href="">Send</a> 
	</nav>
	</div>
  </body>
</html>
