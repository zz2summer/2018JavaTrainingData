<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminPageLeft.jsp' starting page</title>
    
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
    <table>
  <tr>
  <td>
 管理员操作
  </td>
  </tr>
    <tr>
  <td>
  admin,管理员,您好!
  </td>
  </tr>
  <tr>
  <td>
  <a href="/BookShop/managerView/adminMain.jsp">后台管理首页</a>
  </td>
  </tr>
  <tr>
  <td>
  <a href="/BookShop/managerView/categoryManage.jsp">图书类别管理</a>
  </td>
  </tr>
  <tr>
  <td>
  <a href="/BookShop/managerView/bookInfoManage.jsp">图书信息管理</a>
  </td>
  </tr>
    <tr>
  <td>
  <a href="/BookShop/servlet/Admin?requestType=sales">图书销售信息</a>
  </td>
  </tr>
  <tr>
  <td>
  <a href="/BookShop/servlet/Admin?requestType=logout">退出管理系统</a>
  </td>
  </tr>
  </table>
    
    
  </body>
</html>
