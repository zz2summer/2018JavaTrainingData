<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:useBean id="reguser" scope="page" class="book.bk"></jsp:useBean>
<%
	String name = request.getParameter("regname");
	String pwd = request.getParameter("password");
	System.out.print(name);
	String sql = "insert into clients(name,password) values ('" + name
			+ "','" + pwd + "')";

	reguser.executeUpdate(sql);
	response.sendRedirect("login.html");
%>
 

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
</head>
<body>

</body>
</html>