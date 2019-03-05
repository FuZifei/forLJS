<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register</title>
    
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
	
	<script type="text/javascript">
		function check(){
			
			//Check not empty:
			if(document.getElementById('useremail').value==''){
				alert("Please enter your email as your username.");
				return false;
			}
			
			if(document.getElementById('username').value==''){
				alert("Please enter your name.");
				return false;
			}
			
			if(document.getElementById('password').value==''){
				alert("Please set your password.");
				return false;
			}
			
			//Check email format
			var myforms = document.forms;
			var myemail = myforms[0].useremail.value;
			var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
			
			if(myReg.test(myemail)){
				return true;}
			else{
				alert("Wrong email format.");
				return false;
			}
			
		}
	</script>

  </head>
  
  <body>

  <form method="post" action="userregister">
  		
		<h2><label>Please enter the following information:</label></h2><br><br><br>
    	<label>Your E-mail: </label>&nbsp;&nbsp;<input id="useremail" name="useremail" type="text"/><br><br>
		<label>Your name: </label>&nbsp;&nbsp;<input id="username" name="username"/><br><br>
    	<label>Password: </label>&nbsp;&nbsp;<input id="password" name="password" type="password"/><br><br>
    	
		<input type="submit" name="submit" value="submit" onclick="return check()"/>
    	<input type="button" name="back" value="Back" onclick="window.location.href='./Welcome'"/>
    
    </form>
 
  </body>
</html>
