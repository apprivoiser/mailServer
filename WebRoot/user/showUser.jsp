<%@ page language="java" import="java.util.*,com.hnu.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">管理信息</a></li>
    <li><a href="#">查看用户信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li><span><img src="images/t01.png" /></span><a href="user?oper=addPage">添加用户</a></li>
        </ul>
	</div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>密码</th>
        <th>类型</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
        	List<User> lu=(ArrayList<User>)request.getAttribute("lu");
        	for(User u:lu){
        %>
	        <tr>
	        <td><%=u.getUid() %></td>
	        <td><%=u.getUname() %></td>
	        <td><%=u.getPwd() %></td>
	        <%
	        	if(1==u.getType()){
	        %>
	        <td>管理员</td>
	        <%}else{ %>
	         <td>普通用户</td>
	        <%} %>
	        <td><a href="user?oper=update&uid=<%=u.getUid()%>&uname=<%=u.getUname()%>&pwd=<%=u.getPwd()%>&type=<%=u.getType()%>" class="tablelink">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;
	        <a href="user?oper=delete&id=<%=u.getUid()%>" class="tablelink">删除</a>  &nbsp;&nbsp;&nbsp;&nbsp; 
	        <a href="mail?oper=show" class="tablelink">发邮件</a></td>
	        </tr>
        <%} %> 
        </tbody>
    </table>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>