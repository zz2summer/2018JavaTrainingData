<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>My JSP 'adminLogin.jsp' starting page</title>
    
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
  <jsp:include flush="true" page="../userView/public/title.jsp"></jsp:include>
  
 <form action="/BookShop/servlet/Admin?requestType=adminLogin" method="post" name = "ad">
<table border="1" width="300" height="162" bordercolor="#C0C0C0"
bordercolorlight="#808080" bordercolordark="#808080" bgcolor="#C0C0C0">
  <tr>
    <td width="100%" align="center" height="16" bgcolor="#C0C0C0">管理员登陆</td>
  </tr>
  <tr>
    <td width="100%" align="center" height="23" bgcolor="#C0C0C0">用户名:<input type="text"
    name="name" size="20"></td>
  </tr>
  <tr>
    <td width="100%" align="center" height="29" bgcolor="#C0C0C0">密  码:&nbsp;&nbsp;<input
    type="password" name="password" size="20"></td>
  </tr>
  <tr bgcolor="#C0C0C0">
    <td width="100%" align="center" height="29"><table height="20">
      <tr>
        <td>
          <p><input type="submit" value="登陆"> </p>
        </td>
        <td>
          <input type="reset" value="取消">
        </td>
        <td>&nbsp;&nbsp;&nbsp; <a href="/BookShop/index.jsp">返回首页</a></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr bgcolor="#C0C0C0">
    <td width="100%" height="30" align="center"><small>友情提示:管理员用户名和密码均为<font
    color="#FF0000">admin</font></small></td>
  </tr>
</table>
</form>
	<br><br><br><br>
	<jsp:include flush="true" page="../userView/public/buttom.jsp"></jsp:include>
</center>
  </body>
</html>
