<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：用户注册成功提示界面 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registSuccess.jsp' starting page</title>
    
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
  <%@include file="public/title.jsp" %>
    <form>
    <table width="100%">
  <tr>
    <td width="100%" align="center">恭喜您,注册成功!</td>
  </tr>
  <tr>
    <td width="100%" align="center">您现在可以<a href="/BookShop/userView/login.jsp">登陆</a>|<a href="/BookShop/index.jsp">进入首页</a></td>
  </tr>
</table>
    </form>
    <%@include file="public/buttom.jsp" %>
  </body>
</html>
