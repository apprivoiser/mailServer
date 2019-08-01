<%@ page language="java" import="java.util.*,com.hnu.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>


<body>


	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">日常管理</a></li>
    <li><a href="#">发邮件</a></li>
    </ul>
    </div>
           
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发送邮件</a></li> 
  	</ul>
    </div> 
  	<div id="tab1" class="tabson">
    
    <ul class="forminfo">
    <form action="mail" method="post">
		<input type="hidden" name="oper" value="send" />
    <li><label>邮件主题<b>*</b></label><input name="subject" type="text" class="dfinput" placeholder="请填写邮件主题"  style="width:518px;"/></li>
   <li><label>发件人<b>*</b></label> &nbsp;&nbsp;&nbsp;&nbsp; <label><%=((User)session.getAttribute("user")).getUname()%></label></li>
    <li><label>收件人<b>*</b></label>  
    
    <div class="vocation">
    <select class="select1" name="to_user">
    <%
        	List<User> lu=(ArrayList<User>)request.getAttribute("lu");
    if(lu==null){
    	System.out.println("lu是空的！");
    }
        	for(User u:lu){
        		System.out.println(u.getUname());
        		if(!u.getUname().equals(((User)session.getAttribute("user")).getUname())){
     %>
    <option><%=u.getUname() %> </option>
    
    <%}} %>
    </select>
    </div>
    
    </li>
    
    <li><label>邮件内容<b>*</b></label>
    
    <textarea id="content7" name="content" style="width:700px;height:250px;visibility:hidden;"></textarea>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="发送"/></li>
    </form>
    </ul>
    
    </div> 
    
    
  	<div id="tab2" class="tabson">
   
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

    </div>
   
</body>

</html>