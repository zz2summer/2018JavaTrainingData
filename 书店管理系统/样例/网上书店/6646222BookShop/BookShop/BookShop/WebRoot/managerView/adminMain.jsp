<%@ page language="java" import="java.util.*,dao.*,beans.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'categoryManage.jsp' starting page</title>

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
	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	 %>
	 <%@include file="adminPageHead.html"%>
		<table align="center" width="750">
			<tr>
				<td width="180" align="left">
					<jsp:include flush="true" page="adminPageLeft.jsp">
						<jsp:param name = "username" value = "jack"/>
					</jsp:include>
				</td>

				<td width="420">
					管理员，你好！请选择左侧的菜单进行相应的操作！
					
				</td>
			</tr>
		</table>
		<table align="center">
		<tr><td width="750"><%@include file="../userView/public/buttom.jsp"%></td></tr>
		</table>
	</body>
</html>
