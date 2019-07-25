<%@ page language="java" import="java.util.*,beans.*,dao.*"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP 'bookInfoManage.jsp' starting page</title>

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
		<center>
		<%@include file="adminPageHead.html"%>
			<table width=750>
				<tr>
					<td width=200 align=left>
						<jsp:include page="adminPageLeft.jsp" ></jsp:include>
					</td>
					<td width=420 align=center>
						<form>
							<%
								BookDAO bookDAO = new BookDAO();
								ArrayList bookList = new ArrayList();
								bookList = bookDAO.querryAllBooks();
							%>
							<table valign=top align="right">
								<tr>
									<td width="450" align="center" colspan="7">
										图书信息管理
									</td>
								</tr>
								<tr>
									<td width="40"></td>
									<td width="60"></td>
									<td width="60"></td>
									<td width="60"></td>
									<td  align="right" colspan="3">
										<a href="/BookShop/managerView/addBook.jsp">新增图书</a>
									</td>
								</tr>
								<tr>
									<td width="40" align="center">
										编号
									</td>
									<td width="80" align="center">
										图书名称
									</td>
									<td width="60" align="center">
										单价
									</td>
									<td width="60" align="center">
										出版社
									</td>
									<td width="80" align="center">
										详细信息
									</td>
									<td width="70" align="center">
										修改
									</td>
									<td width="70" align="center">
										删除
									</td>
								</tr>
								<%
									int num = bookList.size();
									for (int i = (num - 5) >= 0 ? (num - 5) : 0; i < num; i++) {
										Book book = (Book) bookList.get(i);
								%>
								<tr>
									<td width="40" align="center">
										<%=i + 1%>
									</td>
									<td width="80" align="center">
										<%=book.getName()%>
									</td>
									<td width="60" align="center">
										<%=book.getPrice()%>
									</td>
									<td width="60" align="center">
										<%=book.getBookman()%>
									</td>
									<td width="80" align="center">
										<a
											href="/BookShop/servlet/Admin?ID=<%=book.getId()%>&requestType=query" target=_blank>查看</a>
									</td>
									<td width="70" align="center">
										<a
											href="/BookShop/managerView/modifyBook.jsp?bookId=<%=book.getId()%>">修改</a>
									</td>
									<td width="70" align="center">
										<a
											href="/BookShop/servlet/Admin?ID=<%=book.getId()%>&requestType=deleteBook">删除</a>
									</td>
								</tr>
								<%
								}
								%>

							</table>
						</form>
					</td>
				</tr>
				<tr><td colspan =2><jsp:include page = "../userView/public/buttom.jsp"></jsp:include></td></tr>
			</table>
		</center>
	</body>
</html>
