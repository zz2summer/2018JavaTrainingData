<%@ page language="java" import="java.util.*,beans.*"
	pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP 'buttom.jsp' starting page</title>

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
			User user = (User) session.getAttribute("userInfo");
			
			ArrayList al = (ArrayList) request.getAttribute("allBooks");
			session.setAttribute("userInfo",user);
		
		%>

		<table align="center">
			<tr>
				<td  align=center colspan=6>
				图书列表
				</td>
			</tr>
			<tr>
				<td width = 100>图书名称</td>
				<td width = 100>作者</td>
				<td width = 100>出版社</td>
				<td width = 100>单价</td>
				<td width = 100>状态</td>
				<td width = 100>加入购物车</td>
			</tr>
			<%
					for (Iterator it = al.iterator(); it.hasNext();) {
					Book bk = (Book) it.next();
			%>
			<tr>
				<td><a href = "/BookShop/userView/detailAboutBook.jsp?bookId=<%=bk.getId()%>"><%=bk.getName() %></a></td>
				<td><%=bk.getAuthor() %></td>
				<td><%=bk.getBookman() %></td>
				<td><%=bk.getPrice() %>元</td>
				<td><%=bk.getRemainNum() %></td>
				<td><a href ="/BookShop/servlet/user?remainNum=<%=bk.getRemainNum() %>&requestType=addBasket&bookId=<%=bk.getId()%>">加入购物车</a></td>
			</tr>

			<%
			}
			%>
		</table></center>
	</body>
</html>
