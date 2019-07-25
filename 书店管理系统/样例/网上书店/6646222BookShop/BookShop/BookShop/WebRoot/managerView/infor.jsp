<%@ page language="java" import="java.util.*,beans.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'infor.jsp' starting page</title>
    
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
 <%@include file="../userView/userpage/title.jsp"%>
 
  	<% 
  		String categoryName = (String) request.getAttribute("categoryName");
  		Book book = (Book)request.getAttribute("book"); %>
  	
    
<center>
<table border="1" width="750" height="150">
	<tr><td width="100%" colspan ="4" align="center"><strong>图书详细信息</strong></td></tr>
   	<tr>
    <td  height="55">图书名称:</td>
    <td height="55"><%=book.getName() %></td>
    <td  height="55">类别:</td>   
    <td height="55"><%=categoryName %></td>
  </tr>
  <tr>
    <td  height="49">单价:</td>
    <td  height="49"><%=book.getPrice() %></td>
    <td  height="49">作者:</td>
    <td  height="49"><%=book.getAuthor() %></td>
  </tr>
  <tr>
    <td  height="54">出版社:</td>
    <td  height="54"><%=book.getBookman() %></td>
    <td  height="54">入库数</td>
    <td  height="54"><%=book.getOnSaleNum()%></td>
  </tr>
  <tr>
    <td  height="52">现有库存</td>
    <td  height="52"><%=book.getRemainNum() %></td>
    <td  height="52">上架时间</td>
    <td  height="52"><%=book.getOnSaleDate() %></td>
  </tr>
  <tr>
    <td  height="49">图书简介</td>
    <td  height="49" colspan="3"><%=book.getIntroduction() %></td>
  </tr>
  <tr>
    <td  height="60" colspan="2"> 
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="#" onClick="window.close()"> 关闭窗口</a>
    </td>
    <td  height="60" colspan="2"> 
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     购物请登录
     </td>
  </tr>

</table>
<%@include file="../userView/public/buttom.jsp"%>
</center>
  </body>
</html>
