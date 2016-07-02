<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<script type="text/javascript">
	$(".submitbutton").click(function(){
		$('#loginform').submit();
	});
	$(".registerbutton").click(function(){
		$('#registerform').submit();
	});
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
    
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
请输入登录信息 ：<br>
    <div class="submitdiv">
    
    <form id="loginform" action="${pageContext.request.contextPath}/user/login.do" method="post" >
   <!--  
      <div class="tip">
        用户名:<input class="userName" name="userName" type="text" />
      </div>
      <div class="tip">
        密&nbsp;&nbsp;&nbsp;码:<input class="password" name="password" type="password" />
      </div>
      
  -->    
    <div>
     	  用户名:<input class="userName" name="userName" value="${user.userName}" type="text" />
    </div>
    <div>
                       密&nbsp;&nbsp;码:<input class="password" name="password" value="${user.password}" type="password" />
    </div>
    
    <div class="tip">
       <input class="submitbutton"  type="submit" value="登陆" />
    </div>
   </form>
   
   </div> 
<!--
   <form id="registerform" action="${pageContext.request.contextPath}/user/registerView.do" method="post" >
     
       <input class="registerbutton"  type="submit" value="注册新账户" />

   </form>
-->
	<br>
	<c:if test="${not empty errorMsg}">
		<c:out value="${errorMsg}"></c:out>
	</c:if>

	<br><a href="${pageContext.request.contextPath}/user/registerView.do">注册新账户</a>
  </body>
</html>
