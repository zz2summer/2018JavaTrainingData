<%@ page language="java" import="java.util.*,beans.*"
	pageEncoding="utf-8"%>
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

		<title>My JSP 'left.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<% 	
		ArrayList categoryList = (ArrayList) request.getAttribute("category");
		if(categoryList == null) {
			response.sendRedirect("/BookShop/servlet/Index?requestType=left");
		}
	%>
	<body>
		<table>
			<tr>
				<td bgcolor="#C0C0C0" width="150" height="10">
					<center>
						<font size=2>所有图书类别</font>
					</center>
				</td>
			</tr>
			<%
				if(categoryList != null) {
					Iterator iter = categoryList.iterator();
					while(iter.hasNext()) {
						BookCategory bc = (BookCategory) iter.next();
				
			 %>
			 	<tr>
			 		<td><%= bc.getName() %></td>
			 	</tr>
			 <%
			 		}
			 	}
			  %>
		</table>
		<table>
			<tr>
				<td bgcolor="#C0C0C0" width="150" height="10">
					<center>
						<font size=2>新书上架</font>
					</center>
				</td>
			</tr>
			<%
				ArrayList bookList = (ArrayList) request.getAttribute("books");
				if(bookList != null) {
					int num = bookList.size();
					for(int i=(num-5)>=0?(num-5):0; i<num; i++) {
						Book book = (Book) bookList.get(i);	
			 %>
			 <tr>
			  <td><%= book.getName() %> </td>
			 </tr>
			 <%
			 		}
			 	}
			  %>
		</table>
	</body>
</html>
