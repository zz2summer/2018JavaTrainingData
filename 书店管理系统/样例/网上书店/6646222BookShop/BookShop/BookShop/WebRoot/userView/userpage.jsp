<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 功能：登陆后的用户首页 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'userpage.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<center><table width="750">
	<tr><td width="750"><jsp:include page = "userpage/title.jsp" flush="true"></jsp:include></td></tr>
	<tr><td><jsp:include page = "userpage/buttom.jsp" flush="true"></jsp:include></td></tr>
	<tr><td><%@include file="../userView/public/buttom.jsp" %></td></tr>
	</table></center>

</html>
