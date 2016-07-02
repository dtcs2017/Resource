<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(".submitbutton").click(function(){
		$('#subform').submit();
	});
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册用户</title>
    
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
	用户注册<br>
	
	<c:if test="${not empty errorMsg}">
		<c:out value="${errorMsg}" ></c:out>
	</c:if>
	
   <form class="subform" action="${pageContext.request.contextPath}/user/register.do" method="post">

   <div>
     	  用户名:<input class="userName" name="userName" value="${user.userName}" type="text" />
    </div>
    <div>
                       密&nbsp;&nbsp;码:<input class="password" name="password" value="${user.password}" type="password" />
    </div>
    <br><br>
    <div>
      <input class="submitbutton" type="submit" value="注   册" />
    </div>
    
   </form>
   
  </body>
</html>
