<%@ page language="java" import="java.util.*,com.hnu.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println("小页面：：：：");
System.out.println(path);
System.out.println(basePath);
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
    </ul>
    </div>
    
    <div class="mainindex">

    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>SMTP协议</b>
    </div>
    
    <ul class="infolist">
    <li><span>启动SMTP协议</span><a href="service?oper=1" class="ibtn" >启动</a></li>
    </ul>
    
    <ul class="infolist">
    <li><span>关闭SMTP协议</span><a href="service?oper=2" class="ibtn">关闭</a></li>
    </ul>
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>POP3协议</b>
    </div>
    
    <ul class="infolist">
    <li><span>启动POP3协议</span><a href="service?oper=3" class="ibtn">启动</a></li>
    </ul>
    
    <ul class="infolist">
    <li><span>关闭POP3协议</span><a href="service?oper=4" class="ibtn">关闭</a></li>
    </ul>
    
   </div>
    
    
</body>

</html>