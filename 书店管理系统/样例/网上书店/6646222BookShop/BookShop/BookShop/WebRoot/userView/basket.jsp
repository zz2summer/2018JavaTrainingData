<%@ page language="java" import="java.util.*,beans.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：购物车列表 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'basket.jsp' starting page</title>
    
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
  	 <jsp:include page="userpage/title.jsp"/>
  	 
    <center><h5>购物车列表<h5></center>
        <% ArrayList al = (ArrayList)request.getAttribute("basket"); %>
   <form action="/BookShop/servlet/user?requestType=payBook" method="post">
   <table  align="center">
   <tr><td width="120">
   		图书名称
   		</td>
   		<td width="120">
   		单价
   		</td>
   		<td width="120">
   		数量
   		</td>
   		<td width="120">
   		总价
   		</td>
   		<td width="120" colpan="2">
   		加入日期
   		</td>
   		</tr>
   	<%!int id; %>
   	<%	if(al!=null){
   		Iterator iter = al.iterator();
   		while(iter.hasNext()) {
   		Basket bk = (Basket)iter.next();
   		id = bk.getId();
   	%>
   <tr><td><%=bk.getName()%></td><td><%=bk.getUnitPrice() %></td><td><%=bk.getNumber()%></td><td><%=bk.getTotalPrice() %></td>
   		<td><%=bk.getAddDate() %></td>
   		<td><a href="/BookShop/servlet/user?bookId=<%=id%>&requestType=deleteBook">移出购
物车</a></td>
   </tr>
	<%} 
		}al=null;%>
	<tr><td colspan="6" align="center"><input type="submit" value="结帐"></td></tr>
   </table>
   </form>
   <jsp:include page="public/buttom.jsp"/>
  </body>
</html>
