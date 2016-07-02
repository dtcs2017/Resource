<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示全部用户</title>
    
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
    全部用户信息如下：<br>
    
<table>
	
	<c:choose>
		<c:when test="${empty users}">
			<tr>
				<td colspan="5">there isn't data!</td>
			</tr>
		</c:when>
		<c:otherwise>
		<tr>
		<th width="5%">ID</th>
		<th width="15%">Name</th>
		<th width="12%">password</th>
		<th width="5">delete</th>
		<th width="5">change</th>
		</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.userName}</td>
					<td>${user.password}</td>
					<td><a href="${pageContext.request.contextPath}/user/deleteView.do?userid=${user.id}&userName=${user.userName}">删除用户</a></td>
					<td><a href="${pageContext.request.contextPath}/user/changeView.do?userid=${user.id}&userName=${user.userName}">修改用户</a></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
		<br>
		<a href="${pageContext.request.contextPath}/user/loginView.do">返回登录</a>		
  </body>
</html>
