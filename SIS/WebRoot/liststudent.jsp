<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生基本信息维护</title>
<style type="text/css">
p {
	cursor: pointer;
	color: blue;
}
</style>
<link href="css/page.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/page.js"></script>
<script type="text/javascript" src="js/mypro.js"></script>
</head>

<body>
	<div id="title">
		<h1>学生基本信息维护</h1>
	</div>
	<div id="select_condition">
		学号：<input id="id" type="text" name="textfield" class="input" />
		<!-- 显示联想搜索的结果面板 -->
		<div id="res"
			style="width:200px;height:150px;background-color:red;overflow-y:auto;display:none">
		</div>
		名称：<input id="classname" type="text" name="textfield2" class="input" />
		班级：<input id="class" type="text" name="textfield3" class="input" /> <input
			id="btn" type="button" name="Submit" value="检索" /> <input
			type="button" onclick="window.location.href='index.jsp'" value="返回">
	</div>
	<div id="select_list">
		<table id="table" width="780" border="1" cellspacing="1">
			<thead>
				<tr>
					<th>序号</th>
					<th>学号</th>
					<th>姓名</th>
					<th>班级</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach var="stu" items="${stus}">
					<tr id="stu_${stu.id}">
						<td>${stu.id}</td>
						<td>${stu.studentNo}</td>
						<td>${stu.studentName}</td>
						<td>${stu.studentClass}</td>
						<td><a href="javascript:a(${stu.id})">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<ul class="page" maxshowpageitem="5" pagelistcount="10" id="page"></ul>
</body>
<script type="text/javascript">
	function a(id) {
		$.ajax({
			type : "get",
			url : "SearchServlet?type=delete&id=" + id,
			success : function(msg) {
				alert(msg);
				if ("删除成功" == msg) {
					$("tr").remove("#stu_" + id);
				}
			}
		});
	}
</script>
</html>
