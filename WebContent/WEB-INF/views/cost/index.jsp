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
<form class="form-inline definewidth m20" action="cost/index" method="post">  
   合同名：
    <input type="text" name="title" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>合同编号</th>
        <th>合同名</th>
        <th>创建时间</th>
        <th>管理操作</th>
    </tr>
    </thead>
       <c:forEach var="x" items="${page.result}"> 
        <tr> 
          <td>${x.id}</td> 
          <td>${x.name}</td>
          <td>${x.createtime}</td>
          <td>
                  <a href="cost/add?agreementid=${x.id}">创建记录</a>
                  <a href="cost/view?agreementid=${x.id}">查看记录</a>
            </td>
        </tr> 
</c:forEach>
        </table>
<div class="inline pull-right page">
         ${page.totalCount} 条记录  ${page.pageNo}/${page.totalPages} 页  <a href="cost/index?pageNo=1">首页</a>  <a href="cost/index?pageNo=${page.pageNo-1}">上一页</a>  <a href="cost/index?pageNo=${page.pageNo+1}">下一页</a>      <a href='cost/index?pageNo=${page.totalPages}' >最后一页</a>    </div>
</body>
</html>