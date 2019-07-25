<%@ page language="java" import="java.util.*,beans.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：图书类别管理界面 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'categorymanage.jsp' starting page</title>
    
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
  <h1><center>图书类别管理</center></h1>
  <table>
  <tr>
  <td colspan="2"></td>
  <td colspan="2">新增图书类别</td>
  </tr>
  <tr>
  <td>类别编号</td>
  <td>图书类别</td>
  <td><INPUT TYPE="submit" NAME="change" VALUE="修改"></td>
  <td><INPUT TYPE="submit" NAME="delete" VALUE="删除"></td>
  </tr>
    <%
    ArrayList arr=(ArrayList)request.getAttribute("arr"); 
    Iterator iter=arr.iterator();
    while(iter.hasNext()){
    BookCategory bookCate = (BookCategory)iter.next();
    
    %>
    <tr>
    <td><%=bookCate.getId() %></td>
    <td><%=bookCate.getName() %></td>
    <%}%>
    <td><INPUT TYPE="submit" NAME="change" VALUE="修改"></td>
    <td><INPUT TYPE="submit" NAME="delete" VALUE="删除"></td>
    </tr>
    </table>
  </body>
  </html>
    