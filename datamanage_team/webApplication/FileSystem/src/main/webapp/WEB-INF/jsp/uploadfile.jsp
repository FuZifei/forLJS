<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Upload File</title>
    
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
  
<form action="${pageContext.request.contextPath}/fileUpLoad" method="post"  enctype="multipart/form-data">
File name<input type="file" name="file"/><br/>
     <input type="submit" value="submit"/><br/>
</form>
<h3>test2.txt</h3><br>
<a href="${pageContext.request.contextPath}/fileDownLoad">Download</a>
  </body>
</html>
