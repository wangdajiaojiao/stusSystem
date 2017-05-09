<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生成绩录入系统</title>
</head>
<body>
	<div id="title" align="center"><h1>学生成绩录入系统</h1></div>
	<div id="operation">
		<div id="link_student" align="center">
			<a href="AllServlet">学生基本信息维护</a>
		</div>
	</div>
	
</body>
</html>
