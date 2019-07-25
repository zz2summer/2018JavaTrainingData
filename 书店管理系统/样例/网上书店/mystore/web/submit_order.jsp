<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:useBean id="workM" scope="page" class="book.bk"></jsp:useBean>
<%
	String tel = request.getParameter("address");
	tel = new String(tel.getBytes("utf-8"));
	String address = request.getParameter("tel");
	address = new String(address.getBytes("utf-8"));
	String sqlinsert = "update orders set user_address='" + address
			+ "',user_tel='" + tel + "' where user_name='"
			+ session.getAttribute("username") + "'";
	workM.executeQuery(sqlinsert);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>确认订单界面</title>
</head>
<body>

	<table width="80%" height="171" border="0" align="center">
		<tr>
			<td colspan="2"><div align="center">
					<span class="STYLE1">请详细填写以下资料，然后单击“发出订单”按钮</span>
				</div>
			</td>
		</tr>
		<tr>
			<td bgcolor="#00FF00" class="STYLE1"><div align="center">姓名：</div>
			</td>
			<td><%=session.getAttribute("username")%></td>
		</tr>
		<tr>
			<td bgcolor="#33FF00" class="STYLE1"><div align="center">住址</div>
			</td>
			<td><%=address%></td>
		</tr>
		<tr>
			<td bgcolor="#33FF00" class="STYLE1"><div align="center">电话：</div>
			</td>
			<td><%=tel%></td>
		</tr>
		<tr>
			<td height="55" colspan="2"><div align="center">
					<span class="STYLE2"><a href="index.jsp">继续购书
					</span> <a href="index.jsp">返回首页 
				</div>
			</td>
		</tr>
	</table>
	<p align="center" class="STYLE1">
		<strong> 你选购了以下书籍</strong>
	</p>
	<table width="80%" border="2" align="center" bgcolor="#669999">
		<tr>
			<td><span class="STYLE2">购买数量</span>
			</td>
			<td><span class="STYLE2">书名</span>
			</td>
			<td><span class="STYLE2">单价（元）</span>
			</td>
			<td><span class="STYLE2">总价格（元）</span>
			</td>
		</tr>
		<%
			double g_price, total_price;
			g_price = 0;
			total_price = 0;
			String sqlList = "select * from orders where user_name='"
					+ session.getAttribute("username") + "'";
			ResultSet RSList = workM.executeQuery(sqlList);
			try {
				while (RSList.next()) {
					int b_num;
					b_num = RSList.getInt("book_number");
		%>

		<%
			String sqlBook = "select * from books where id="
							+ RSList.getInt("book_id");
					ResultSet RSBook = workM.executeQuery(sqlBook);
					while (RSBook.next()) {
		%>
		<%
			double price;
						price = RSBook.getDouble("price");
		%>
		<tr>
			<td><span class="STYLE2"></span><%=b_num%></td>
			<td><%=RSBook.getString("name")%></td>
			<td><%=price%></td>
			<td><%=(float) price * b_num%></td>
		</tr>

		<%
			}
		%>

		<%
			}
			} catch (Exception e) {

			}
		%>

	</table>
</body>
</html>