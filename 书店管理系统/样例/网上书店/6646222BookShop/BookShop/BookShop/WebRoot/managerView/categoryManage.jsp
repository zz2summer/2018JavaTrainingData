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
	 <center>
		<%@include file="adminPageHead.html"%>
		<table	width=750>
			<tr>
				<td width=180>
					<jsp:include flush="true" page="adminPageLeft.jsp">
						<jsp:param name = "username" value = "jack"/>
					</jsp:include>
				</td>

				<td width=420>

					<table>

						<tr>
							<td colspan=4 align = "center">
								<font size=6>图书类别管理</font>
							</td>
						</tr>
						<tr><td  align = "right" colspan = 4><a href = "/BookShop/managerView/addCategory.jsp">新增图书类型</a></td></tr>
						<tr>
							<td width = 105>类别编号</td>
							<td width = 105>图书类别</td>
							<td width = 105>修改</td>
							<td width = 105>删除</td>
						</tr>
						<% 
							BookCategoryDAO bcdao = new BookCategoryDAO();
							ArrayList al = bcdao.querryAllCategory();
							for(Iterator it = al.iterator();it.hasNext();){
								BookCategory bc = (BookCategory) it.next();
								%>
							 
							<tr>
								<td><%=bc.getId() %></td>
								<td><%=bc.getName() %></td>
								<td><a href = "/BookShop/managerView/modifyCategory.jsp?categoryId=<%=bc.getId()%>&categoryName=<%= bc.getName()%>">修改</a></td>
								<td><a href = "/BookShop/servlet/Admin?requestType=delete&categoryId=<%=bc.getId()%>">删除</a></td>
							</tr>
							
						<%
							}
						%>
						
						
					</table>
				</td>
			</tr>
		</table>
		<%@include file="../userView/public/buttom.jsp"%>
	</center>
	</body>
</html>
