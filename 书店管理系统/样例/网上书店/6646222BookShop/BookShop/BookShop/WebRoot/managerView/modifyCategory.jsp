<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'modifyCategory.jsp' starting page</title>

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
			<table>
				<tr>
					<td colspan=2>
						<%@include file="adminPageHead.html"%>
					</td>
				</tr>
				<tr>
					<td>
						<jsp:include flush="true" page="adminPageLeft.jsp"></jsp:include>
					</td>

					<td align="center">
						<%
							String categoryId = request.getParameter("categoryId");
							String categoryName = new String(request.getParameter("categoryName").getBytes("ISO-8859-1"),"UTF-8");
						%>
						<form
							action="/BookShop/servlet/Admin?requestType=modifyCategory&categoryId=<%=categoryId%>"
							method="post">

							<table border=0 width="263" height="124">
								<tr>
									<td width="60%" height="41" colspan=3>
										<font size=5><center>
												修改图书类别
											</center> </font>
									</td>
								</tr>
								<tr>
									<td width="40%" height="58">
										<font size=3>图书类别:</font>
									</td>
									<td width="60%" height="58" colspan=2>
										<input type="text" name="categoryName" size="20"
											value="<%=categoryName%>"></input>
									</td>
								</tr>
								<td></td>
								<td>
									<input type="submit" value="修改" name="add">
								</td>
								<td>
									<input type="reset" value="重置" name="reset">
								</td>
								</tr>
							</table>

						</form>
					</td>
				</tr>
				<tr>
					<td align="center" colspan=2>
						<%@include file="../userView/public/buttom.jsp" %>
					</td>
				</tr>
			</table>


		</center>
	</body>