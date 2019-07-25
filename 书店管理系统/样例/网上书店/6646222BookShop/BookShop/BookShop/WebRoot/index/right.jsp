<%@ page language="java" import="java.util.*,beans.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'right.jsp' starting page</title>

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
			ArrayList bookList = (ArrayList) request.getAttribute("books");
			if ( bookList == null) {
				response.sendRedirect("/BookShop/servlet/Index?requestType=right");
			}
		 %>
		<table width="550" border="0" height="186">
			<tr>
				<td colspan="5" height="25">
					<h3>
						<center>
							图书列表
						</center>
					</h3>
				</td>
			</tr>
			<tr>
				<td width="120">
					<font size=2>图书名称</font>
				</td>
				<td width="120">
					<font size=2>作者</font>
				</td>
				<td width="120">
					<font size=2>出版社</font>
				</td>
				<td width="75">
					<font size=2>单价</font>
				</td>
				<td width="50">
					<font size=2>状态</font>
				</td>
			</tr>
			<%  if(bookList == null) {
					System.out.print("asd");
				}
				if(bookList != null) {
					int num = bookList.size();
					for(int i=(num-5)>=0?(num-5):0; i<num; i++) {
						Book book = (Book) bookList.get(i);			
			 %>
			 <tr>
			  <td><font size=2><%= book.getName() %> </font></td>
			  <td><font size=2><%= book.getAuthor() %></font></td>
			  <td><font size=2><%= book.getBookman() %></font></td>
			  <td><font size=2><%= book.getPrice() %></font></td>
			  <td><font size=2><%= book.getRemainNum() %></font></td>
			 </tr>
			 <%
			 		}
			 	}
			  %>
		</table>
	</body>
</html>
