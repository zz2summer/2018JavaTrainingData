<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 功能：首页 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'index.jsp' starting page</title>
    
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
	<table width="750" border="0" align=center>
	  <tr>
	    <td width="750" colspan="2"> <jsp:include page="userView/public/title.jsp"></jsp:include></td>
	  </tr>
		<tr>
	    <td align="right" width="150"><%@include file="index/left.jsp" %></td>
	    <td align="right" width="600"> <jsp:include flush="true" page="index/right.jsp"></jsp:include></td>
	  </tr>
	  <tr>
	    <td colspan="2"><jsp:include page="userView/public/buttom.jsp"></jsp:include></td>
	  </tr>
	</table>
  </body>
</html>
