<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:useBean id="cart" scope="page" class="book.bk"></jsp:useBean>
<%
String book_id = request.getParameter("book_id");
String sql = "select book_id from orders where book_id="+book_id+" and user_name='"+session.getAttribute("username")+"'";
ResultSet rs = cart.executeQuery(sql);
int rowscount = 0;
try{
	while(rs.next()){
		rowscount++;
	}
}catch(Exception e){
	e.printStackTrace();
}
if(rowscount==0){
	String sqlBook1 = "select * from books where id = "+book_id;
	ResultSet rsBook1 = cart.executeQuery(sqlBook1);
	while(rsBook1.next()){
		String sqlCart = "insert into orders(user_name,book_id,book_number,goods_price) values ('"
	+session.getAttribute("username")+"',"+book_id+",1,"+rsBook1.getDouble("price")+")";
		cart.executeUpdate(sqlCart);
	}
}
else{
	String sqlBook2 = "select book_number from orders where book_id = "+book_id+" and user_name = '"+session.getAttribute("username")+"'";
	ResultSet rsBook2 = cart.executeQuery(sqlBook2);
	while(rsBook2.next()){
		int i = rsBook2.getInt("book_number");
		System.out.println(i);
		int count=1+rowscount;
		String sqlCart = "update orders set book_number="+count;
		System.out.println(sqlCart);
		cart.executeUpdate(sqlCart);
	}
}
response.sendRedirect("shopcart.jsp");
%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的购物车</title>
</head>
<body>

</body>
</html>