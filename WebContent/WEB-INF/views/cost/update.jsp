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
<form action="cost/doUpdate" method="post">
<table class="table table-bordered table-hover definewidth m10">
<input type="hidden" name="id" value="${cost.id}">
     <tr>
        <td class="tableleft">标题</td>
        <td><input type="text" name="title" value="${cost.title}" /></td>
    </tr> 
    <tr>
        <td class="tableleft">金额</td>
        <td><input type="text" name="cost" value="${cost.cost}" /></td>
    </tr>
    <tr>
        <td class="tableleft">状态</td>
        <td>
        <select name="state">
        <c:choose>
                  <c:when test="${x.state==0}">
                  <option value="0">支出</option>  
                  <option value="1">收入</option>                    
                  </c:when>
                  <c:otherwise>
                  <option value="1">收入</option>
                  <option value="0">支出</option>
                  </c:otherwise>
                  </c:choose>
        </select>  
        </td>
    </tr>
    <tr>
        <td class="tableleft">描述</td>
        <td>
        <textarea class="textarea" name="description" style="width:400px;height:100px;">${cost.description}</textarea>
        </td>
    </tr>   
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="cost/view";
		 });

    });
    
</script>
 <script>
     if(typeof(${success}!="undifined")){
    if(${success}){
     	alert("保存成功"); 
     }else{ 
     	alert("保存失败"); 
     } 
     } 

 </script> 