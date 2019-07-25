<%@ page language="java" import="java.util.*,dao.*,beans.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：图书详细信息界面 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detailAboutBook.jsp' starting page</title>
    
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
    	int bookId = Integer.valueOf(request.getParameter("bookId")).intValue() ;
    	BookDAO bdao = new BookDAO();
    	Book book = bdao.querryUseId(bookId);
    	
     %>
    <center><table width = 600 border =1>
    	<tr><td>id</td>
    		<td><%=book.getId() %></td>
    		<td>书名</td>
    		<td><%=book.getName() %></td>
    	</tr>
    	<tr><td>作者</td>
    		<td><%=book.getAuthor() %></td>
    		<td>出版商</td>
    		<td><%=book.getBookman() %></td>
    	</tr>
    	<tr>
    		<td>价格</td>
    		<td><%=book.getPrice() %></td>
    		<td>所属目录</td>
    		<td><%=book.getCategoryId() %></td>
    	</tr>
    	<tr>
    		<td>内容简介</td>
    		<td><%=book.getIntroduction() %></td>
    		<td>上架日期</td>
    		<td><%=book.getOnSaleDate() %></td>
    	</tr>
    	<tr>
    		<td>上架数量</td>
    		<td><%=book.getOnSaleNum() %></td>
    		<td>剩余数量</td>
    		<td><%=book.getRemainNum() %></td>
    	</tr>
    </table></center>
    
    
    
    
    
    
  </body>
</html>
