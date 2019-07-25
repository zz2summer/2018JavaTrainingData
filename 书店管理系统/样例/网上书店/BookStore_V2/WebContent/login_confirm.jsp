<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:useBean id="users" scope="page" class="book.bk"></jsp:useBean>
	
<%
String name = request.getParameter("login");
 
String pwd = request.getParameter("password");
 
String sql = "select * from clients where name='"+name+"' and password='"+pwd+"'";

ResultSet rs = users.executeQuery(sql);

if(rs.next()){
	session.setAttribute("username", name);
	response.sendRedirect("index.jsp");
}
else{
	response.sendRedirect("error.html");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录检查</title>
</head>
<body>

</body>
</html>