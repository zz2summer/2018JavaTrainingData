<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:useBean id="shopcart" scope="page" class="book.bk"></jsp:useBean>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选购图书清单</title>
</head>
<body>
<center><h1>购书清单</h1>
<p>您已选购以下书籍:</p>
<form action="order.jsp" method="post">
<table>
	<tr>
		<td>购买数量</td>
		<td>书名</td>
		<td>单价（元）</td>
		<td>总价格（元）</td>
	</tr>
<%
	String sql = "select * from orders where user_name='"+session.getAttribute("username")+"'";
	ResultSet rs = shopcart.executeQuery(sql);
	double total = 0;
	while(rs.next()){
		int id = rs.getInt("book_id");
		String s = "select * from books where id="+id;
		ResultSet rs1 = shopcart.executeQuery(s);
		String name="";
		while(rs1.next()){
			name = rs1.getString("name");
		}
		int number = rs.getInt("book_number");
		double price = rs.getDouble("goods_price");
		%>
		<tr>
		<td><%= number%></td>
		<td><%= name%></td>
		<td><%= price%></td>
		<td><%= price*number%></td>
	</tr>
		<%
		total+=price*number;
		} %>
		<p>总运费为:<%= total%> 元</p>
		<p><a href="index.jsp">继续购物</a>
		<input type="submit" value="填写订单" size="4" />
		</p>

</table>
</form>
</center>

</body>
</html>