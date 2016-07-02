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
<form action="agreement/doAdd" method="post">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">合同类别</td>
        <td>
    <select name="cateid">
    <option value="0" >------------</option>
    <c:forEach var="x" items="${agreementlist}">
    <option value="${x.id}">${x.category}</option>
    </c:forEach>
    </select>
        
        </td>
    </tr> 
     <tr>
        <td class="tableleft">合同名</td>
        <td><input type="text" name="name" /></td>
    </tr>  
    <tr>
        <td class="tableleft">工程名</td>
        <td><input type="text" name="projectname"/></td>
    </tr>   
    <tr>
        <td class="tableleft">工程介绍</td>
        <td>
        <textarea class="text-area" style="width:400px;height:200px;" name="projectintro"></textarea>
        </td>
    </tr>  
    <tr>
        <td class="tableleft">工程预算</td>
        <td><input type="text" name="projectbudget"/></td>
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
				window.location.href="agreement/index";
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