<%@ page language="java" import="java.util.* ,beans.*;" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'title.jsp' starting page</title>
    
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
<center>
  <table width = 700 height = 100 bgcolor = #c0c0c0>
    <tr ><td align = "center" ><font size = 7 face = "Comic sands MS">BookShop online</font> </td></tr>
   </table>
    <hr color = blue width = 700>
   
   <% 
  	 User user = (User) session.getAttribute("userInfo");
   %> 
   <table>
  	<tr> 
  		<td width = 300>尊敬的<%=user.getName() %>,欢迎你的到来</td>
  		<td width = 100><a href = "/BookShop/servlet/Index?requestType=login&username=<%=user.getName() %>&password=<%=user.getPass() %>"><font>用户首页</font></a></td>
  		<td width = 100>个人信息</td>
  		<td width = 100><a href ="/BookShop/userView/userExit.jsp">退出登录</a></td>
  	</tr>
   </table>  </center>
   
   <center>
   <table bgcolor = #c0c0c0 height = 10 width = 700>
   <tr><td></td></tr>
   </table>
  </body>
</html>
