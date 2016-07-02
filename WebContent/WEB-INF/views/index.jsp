<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
		<p style="font-size:20px;">后台管理系统</p>
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${admin.username}</span><a href="<%=basePath%>/admin?method=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		<li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{
        	id:'1',
        	homePage : '2',
        	menu:[{
        		text:'系统管理',
        		items:[
        		       {id:'2',text:'登录管理',href:'<%=basePath%>/admin?method=list'}
        		       ]
        	}]
        },{
        	id:'7',
        	homePage : '8',
        	menu:[{
        		text:'用户管理',items:[
        		       {id:'8',text:'用户列表',href:'user/index'},
        		       {id:'9',text:'添加用户',href:'user/add'}
        		       ]
        	},
        	{
        		text:'公告管理',
        		items:[
        		       {id:'10',text:'公告管理',href:'ad/index'},
        		       {id:'11',text:'添加公告',href:'ad/add'}
        		       ]
        	},
        	{
        		text:'合同管理',items:[
        		       {id:'12',text:'合同管理',href:'agreement/index'},
        		       {id:'13',text:'创建合同',href:'agreement/add'}
        		       ]
        	},
        	{
        		text:'经营管理',items:[
        		       {id:'14',text:'经营管理',href:'cost/index'}
        		       ]
        	},
        	{
        		text:'统计管理',items:[
        		       {id:'15',text:'统计管理',href:'<%=basePath%>/link?method=list'}
        		       ]
        	}]
        }];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>