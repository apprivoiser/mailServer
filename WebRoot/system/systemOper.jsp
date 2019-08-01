<%@ page language="java" import="java.util.*,com.hnu.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<base href="<%=basePath%>">
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
    <li><a href="#">系统设置</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
  	<div id="tab1" class="tabson">
    <form action="system" method="post">
		<input type="hidden" name="oper" value="change" />
    <ul class="forminfo">
    <%
       	int mailboxSize=(int)request.getAttribute("mailboxSize");
    	int SMTPPORT=(int)request.getAttribute("SMTPPORT");
    	int POP3PORT=(int)request.getAttribute("POP3PORT");
    %>
    <li><label>邮箱大小<b>*</b></label><input name="mailboxSize" type="text" class="dfinput" placeholder=<%=mailboxSize %>  style="width:518px;"/></li>
    <li><label>SMTP端口<b>*</b></label><input name="SMTPport" type="text" class="dfinput" placeholder=<%=SMTPPORT %>  style="width:518px;"/></li>
   	<li><label>POP3端口<b>*</b></label><input name="POP3port" type="text" class="dfinput" placeholder=<%=POP3PORT %>  style="width:518px;"/></li>
   	<li><label>域名<b>*</b></label><input name="" type="text" class="dfinput" placeholder="127.0.0.1"  style="width:518px;"/></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="保存"/></li>
    </ul>
    </form>
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