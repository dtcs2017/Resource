<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="ad/index" method="post">  
   公告标题：
    <input type="text" name="title" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增公告</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>公告编号</th>
        <th>公告标题</th>
        <th>创建时间</th>
        <th>管理操作</th>
    </tr>
    </thead>
       <c:forEach var="x" items="${page.result}"> 
        <tr> 
          <td>${x.id}</td> 
          <td>${x.title}</td>
          <td>${x.createtime}</td>
          <td>
                  <a href="ad/update?id=${x.id}">编辑</a>
                  <a onclick="del(${x.id})">删除</a>
            </td>
        </tr> 
</c:forEach>
        </table>
<div class="inline pull-right page">
         ${page.totalCount} 条记录  ${page.pageNo}/${page.totalPages} 页  <a href="ad/index?pageNo=1">首页</a>  <a href="ad/index?pageNo=${page.pageNo-1}">上一页</a>  <a href="ad/index?pageNo=${page.pageNo+1}">下一页</a>      <a href='ad/index?pageNo=${page.totalPages}' >最后一页</a>    </div>
</body>
</html>
<script>
    $(function () {
        
		$('#addnew').click(function(){

				window.location.href="ad/add";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "ad/delete?id="+id;
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>