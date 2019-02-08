<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome</title>
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
		.div-left{float:left; background:"#008B8B";width:100%; height:25%}
		.i{text-align:center; width:100%;height:20%}
	</style>
	
	
  </head>
  
  <body bgcolor="#E0EEE0">
  
  	<div class="div-left"> <h1><font color="white">Welcome to the DMSYS</font></h1></div>
 
    <br><br><br>

    
    <br>
    <div class="i"><h2>Please</h2></div>
    <div class="i">
    <input type="button" name="login" value="LOG IN" onclick="window.location.href('./login.jsp')"/>&nbsp;
    </div>
    <div class="i">
    <h2>or</h2> &nbsp;</div>
    <div class="i">
    <input type="button" name="register" value="REGISTER" onclick="window.location.href('./register.jsp')"/>
   	</div>
  </body>
</html>
