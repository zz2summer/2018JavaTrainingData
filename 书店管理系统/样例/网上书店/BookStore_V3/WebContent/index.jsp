<%@page import="book.SessionCounter"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
if(session.getAttribute("username")==null){
	//检查用户是否登陆过,如果未经过登录检查，返回登陆页面
	response.sendRedirect("login.html");	
}
%>
<jsp:useBean id="mybook" scope="page" class="book.bk"></jsp:useBean>
<%
//确定显示格式
//设置每张网页显示8笔记录
int PageSize = 8;
//设置欲显示的页数
int ShowPage = 1;
//结果集中的记录笔数
int RowCount = 0;
//分页后的总页数
int PageCount = 0;
//建立结果集对象，并执行sql语句
ResultSet rs = mybook.executeQuery("select * from books");
//将指标移至最后一条记录
rs.last();
//取得结果集中的记录的笔数
RowCount = rs.getRow();
//计算显示的页数
PageCount = ((RowCount%PageSize)==0?(RowCount/PageSize):(RowCount/PageSize)+1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>迷你书店</title>
</head>
<body>
<center>
<font size="5" color="blue">欢迎光临</font>
</center>
<center><p>在线人数:<%= SessionCounter.getActiveSessions() %></p>
</center>
<br>
<hr>
<br>
<center>
<%
String ToPage = request.getParameter("ToPage");
//判断是否可正确取得ToPage参数
if(ToPage!=null){
	//取得指定显示分页页数
	ShowPage = Integer.parseInt(ToPage);
	//下面的if语句将判断用户输入的页数是否正确
	if(ShowPage>PageCount){
		//判断指定页数是否大于总页数，是则设置显示最后一页
		ShowPage = PageCount;
	}
	else if(ShowPage<=0){
		//若指定页数小于0，则设置显示第一页的记录
		ShowPage=1;
	}
}
//计算欲显示页的第一笔记录位置
rs.absolute((ShowPage-1)*PageSize+1);
%>
<h3>当前在第<font size="4" color="red">
<%= ShowPage %>
</font>页，共<font size="4" color="red"><%= PageCount %></font>页</h3>
<br>

<table border="2" width="100%">
<tr>
	<td width="33%">书名</td>
	<td width="33%">作者</td>
	<td width="10%">价格（元）</td>
	<td width="24%">购书</td>
</tr>
<%
	int i=0;

	while(rs.next()){
		i=i+1;
%>
<tr>
	<td width="35%"><%=rs.getString("name") %></td>
	<td width="33%"><%=rs.getString("author") %></td>
	<td width="10%"><%=rs.getString("price") %></td>
	<td width="22%"><a href ="cart.jsp?book_id=<%=rs.getInt("id")%>">选购此书</a></td>
</tr>
<%
//超过8条
if(i==PageSize){
	break;
}
%>
<%
	}
	rs.close();
%>
</table>
<table>
<tr valign="baseline" align="center">
<%
//判断目前所在页号是否为第一页
//不是，则显示到第一页与山一页的超链接
if(ShowPage!=1){
	//下面建立的各超链接将连接至自己，
	//并将欲显示的分页以ToPage参数传递给自己
%>
<td width="150">
<a href="index.jsp?ToPage=<%=1 %>">到第一页</a>
</td>
<td width="150">
<a href="index.jsp?ToPage=<%=ShowPage-1 %>">到上一页</a>
</td>
<%
}
//判断目前所在分页是否为最后一页
//不是则显示到最后一页与下一页的超链接
if(ShowPage!=PageCount){
	//下面建立的各超链接将连接至自己
	//并将欲显示的分页以topage参数传递给自己
%>
<td width="150">
<a href="index.jsp?ToPage=<%=ShowPage+1 %>">到下一页</a>
</td>
<td width="150">
<a href="index.jsp?ToPage=<%=PageCount %>">到最后一页</a>
</td>
<%
}
%>
<td width="150">
<form action="index.jsp" method="post">
到
<input type="text" name="ToPage" style="height:25px;width:40px"
 value="<%=ShowPage %>">页
</form>
</td>
</tr>
</table>
</center>
</body>
</html>
