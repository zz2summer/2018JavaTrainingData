<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：将登陆、注册提示界面整合到一起 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <table width="650"  align="center">
	<tr>
		<td width="200" align="right" valign="top"><jsp:include page="login/left.html" /></td>
		<td width="200" align="right"><jsp:include page="login/right.html" /></td>
	</tr>
	<tr>
		<td colspan="2"><jsp:include page="public/bottom.html" /></td>
	</tr>
</table>
	<%@include file="public/buttom.jsp" %>
  </body>
  
</html>
