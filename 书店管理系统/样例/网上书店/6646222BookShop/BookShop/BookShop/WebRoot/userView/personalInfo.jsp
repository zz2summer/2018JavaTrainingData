<%@ page language="java" import="java.util.*,beans.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：用户个人信息显示界面 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personalInfo.jsp' starting page</title>
    
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
    <%@include file="userpage/title.jsp" %>
   <center>
   <table align = "center">
   	<tr  align = "center"><td colspan = "2"><font size = 5>用户详细信息</font></td></tr>
   	<tr><td width = "170">用户名：<%=user.getName() %></td><td width = "170">真实姓名：<%=user.getRealName() %></td></tr>
   	<tr><td width = "170">性别：<%=user.getSex() %></td><td width = "170">年龄：<%=user.getAge() %></td></tr>
   	<tr><td width = "170">Email:<%=user.getEmail() %></td><td width = "170">联系方式：<%=user.getPhone() %></td></tr>
    <tr><td width = "170">联系地址：<%=user.getAddress() %></td><td width = "170">注册时间：<%=user.getRegisterDate() %></td></tr>
  	</table><br>
   </center>
   <%@include file="public/buttom.jsp" %>
  </body>
</html>
