<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：用户退出登陆界面 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userExit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center><jsp:include flush="true" page="public/title.jsp"></jsp:include>
    <%session.invalidate(); %>
   	<br>尊敬的用户,您已经推出本系统，欢迎您的使用！<br>
   	
   		<a href = "/BookShop/index.jsp">返回主页</a>|<a href = "/BookShop/userView/login.jsp">重新登录</a>
    <table bgcolor = #c0c0c0 height = 10 width =600>
   <tr><td></td></tr>
   </table>
   -购书系统- <a href = "" ><font color = red>关于系统</font></a>  JSP+JavaBean+Servlet模式 -联系我们- <a href = "http;//www.javapro.com.cn" ><font color = red>www.javapro.com.cn</font></a>
    </center>
  </body>
</html>
