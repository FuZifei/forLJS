<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
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


	<script>
		function check(){
			//Check not empty:
			if(document.getElementById('useremail').value==''){
				alert("Please enter your email as your username.");
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
   <br><br>
   <h1>Login</h1>
   <br>
   <div id="log in">
   <form method="post" action="userlogin">
	<label>Your E-mail:</label>&nbsp;&nbsp;
    <input type="text"  name="useremail" id="useremail"/><br><br>
    <label>Password:</label>&nbsp;&nbsp;
    <input type="password"  name="password" id="password"/><br><br>    
    <input type="SUBMIT" value="Login"  name="submit" onclick="return check()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="back" value="Back" onclick="window.location.href='./Welcome'"/>
   
   </form>
   </div>
   
  </body>
</html>
