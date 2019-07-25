<%@ page language="java" import="java.util.*,beans.*;" pageEncoding="UTF-8"%>

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
  
  <body >
  		<%
			User user = (User) session.getAttribute("userInfo");
			session.setAttribute("userInfo",user);
		%>
   <center>
   
   <table bgcolor = #c0c0c0 width="750">
   <tr><td align = "center" colspan = 4><font size = 7 face = "Comic sans MS" >BookShop online</font></td></tr>

   </table></center>
   <hr color = blue width = 750>
   
   		<center><table width = 600 align = center>

			<tr>
				<td width = 250>
					尊敬的 <%=user.getName()%>,欢迎你的到来!
				</td>
				<td width = 100>
					<a href="/BookShop/servlet/Index?requestType=homePage">用户首页</a>
				</td>
				<td width = 100>
					<a href="/BookShop/userView/personalInfo.jsp">个人信息</a>
				</td>
				<td width = 100><a href ="/BookShop/servlet/user?requestType=showBasket">查看购物车 </a>
				</td>
				<td width = 100>
					<a href="/BookShop/userView/userExit.jsp">退出登录</a>
				</td>
		</table>
</body>
</html>
