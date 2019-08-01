<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	 <base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>Basic ValidateBox - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加用户</span></div>

    <ul class="forminfo">
    <form action="user" method="post">
    <input type="hidden" name="oper" value="add" />
    <li><label>用户名</label><input name="uname" type="text" class="dfinput" /><i>用户名是邮箱地址</i></li>
    <li><label>密码</label><input name="pwd" type="text" class="dfinput" /><i>字母加数字，不超过20个字符</i></li>
    <li><label>类型</label><cite>管理员: <input type="radio" name="type" value="1"checked="checked"/>&nbsp;&nbsp;&nbsp;&nbsp;普通用户: <input type="radio" name="type" value="0"/></cite></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="保存"/></li>
   	</form> 
    </ul>
     </div>
  

</body>
</html>