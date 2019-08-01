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
    <li><a href="#">日志管理</a></li>
    <li><a href="#">查看日志</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>id<i class="sort"><img src="images/px.gif" /></i></th>
        <th>操作</th>
        <th>时间</th>
        <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <%
        	List<Log> lu=(ArrayList<Log>)request.getAttribute("lu");
        	for(Log u:lu){
        %>
	        <tr>
	        <td><%=u.getId() %></td>
	        <td><%=u.getOperation() %></td>
	        <td><%=u.getDate() %></td>
	        <td><%=u.getState() %></td>
	        </tr>
	      <% }%>
        </tbody>
    </table>

</body>

</html>