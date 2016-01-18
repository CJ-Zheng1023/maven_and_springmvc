<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addstudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="<%=request.getContextPath() %>/hello/save" method="post">
    	<div>
    		<label for="name">name:</label>
    		<input id="name" name="name" />
    	</div>
    	<div>
    		<label for="favorite">favorite:</label>
    		<input id="favorite" name="favorite" />
    	</div>
    	<div>
    		<label for="sex">sex:</label>
    		<select id="sex" name="sex">
    			<option value="male">male</option>
    			<option value="female">female</option>
    		</select>
    	</div>
    	<input type="submit" value="submit" />
    </form>
  </body>
</html>
