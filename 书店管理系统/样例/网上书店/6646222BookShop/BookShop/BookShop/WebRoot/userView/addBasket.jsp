<%@ page language="java" import="java.util.*,beans.*;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：图书加入购物车 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addBasket.jsp' starting page</title>
    
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
  <Script>
  		function checkNum(obj){
  		
  			var remain = <%=request.getParameter("remainNum")%>
  			if(obj<1){
  			
  				alert("请输入有效购买数量!");
  				document.buy.number.focus();
  				return false;
  			}else if(((obj*10)%10)!="0"){
  			
  				alert("请输入整数");
  				document.buy.number.focus();
  				return false;
  			
  			}else if(obj>remain){
  			
  				alert("库存不足!我们会尽快提供!");
  				document.buy.number.focus();
  				return false;
  				
  			}else{
  			
  				return true;
  			}
  		}
  		
  		function sum(){
  		
  			document.buy.totalPrice.value=document.buy.number.value*
  		document.buy.unitPrice.value;
  		
  		}
  </Script>
  <jsp:include page="userpage/title.jsp" flush="true"/>
   <center><h5>图书加入购物车<h5></center>
   <% Book book = (Book)request.getAttribute("addBook"); %>
   <form name="buy" onSubmit="return checkNum(number.value)" action="/BookShop/servlet/user?requestType=insertBasket" method="post">
   <input type="hidden" name="bookName" value="<%=book.getName() %>">
   <input type="hidden" name="unitPrice" value="<%=book.getPrice() %>">
   <input type="hidden" name="bookId" value=<%=book.getId() %>>
   <table  align="center">
   <tr><td width="150">图书名称</td><td width="150">单价</td><td width="150">数量</td><td width="150">总价</td></tr>
   <tr><td whidth="150"><%=book.getName() %></td><td whidth="150"><%=book.getPrice() %></td><td whidth="150"><input type="text" value="1" size="10" name="number" onblur="sum();">本</td>
   		<td whidth="150"><input type="text" name="totalPrice" size="10" value="<%=book.getPrice() %>" disabled=true>元</td>
   </tr>
   <tr>
   		<td colspan="4" align="center"><input type="submit" value="加入购物车"></td>
   </tr>
   </table>
   </form>
      <jsp:include page="public/buttom.jsp" flush="true"/>
  </body>
</html>
