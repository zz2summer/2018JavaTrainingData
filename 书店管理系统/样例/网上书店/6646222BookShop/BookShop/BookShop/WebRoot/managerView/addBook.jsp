<%@ page language="java" import="java.util.*,beans.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">
 	function CheckForm(){
 	
 	if(document.a.name.value==""){
 		alert("请输入图书名！");
 		document.a.name.focus();
 	}else if(document.a.price.value.length==0){
 	
 		alert("请输入图书价格!");
 		document.a.price.focus();
 	}else if(document.a.author.value.length==0){
 	
 		alert("请输入图书作者");
 		document.a.author.focus();
 	}else if(document.a.bookman.value.length==0){
 	
 		alert("请输入出版社");
 		document.a.bookman.focus();
 	}else if(document.a.onSaleNum.value.length==0){
 	
 		alert("请输入入库数量");
 		document.a.onSaleNum.focus();
 	}else if(document.a.remainNum.value.length==0){
 	
 		alert("请输入现有库存");
 		document.a.remainNum.focus();
 	}
 	else if(document.a.onSaleDate.value.length==0){
 	
 		alert("请输入上架时间");
 		document.a.onSaleDate.focus();
 	}
 	else if(document.a.introduction.value.length==0){
 	
 		alert("请输入图书简介");
 		document.a.introduction.focus();
 	}
 	else{
 		return true;
 	}
 	
 	return false;
 }
</script>
  </head>
  
  <body>
     <%
     BookCategoryDAO bcdao = new BookCategoryDAO();
     ArrayList arr = bcdao.querryAllCategory();
     Iterator iter=arr.iterator();
     int i=1;
     %>
	  <form name="a" action="/BookShop/servlet/Admin?requestType=addBook" onSubmit="return CheckForm()"  method="post">
		  <table width="100%">
		  <tr>
		    <td width="100%" colspan="3" align="center">新增图书</td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">图书名称:</td> 
		    <td width="28%"><input type="text" name="name" size="20"></td>
		    <td width="58%" align="center"><font color="#FF0000">请输入图书名称</font></td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">图书类别:</td>
	          <td width="28%"> <select name="categoryId">
		    	<%while(iter.hasNext()){    	     
		             BookCategory bc=(BookCategory)iter.next();
		         %>
		         <option value="<%= bc.getId() %>"><%=bc.getName() %></option>
		         <% 
		           } 
		         %>
			    </select> </td>
		    <td width="58%" align="center"><font color="#FF0000">请输入图书类别</font></td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">图书价格: </td>
		    <td width="28%"><input type="text" name="price" size="20"></td>
		    <td width="58%" align="center"><font color="#FF0000">请输入图书价格</font></td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">图书作者:</td>
		    <td width="28%"> <input type="text" name="author" size="20"></td>
		    <td width="58%" align="center">请输入图书作者</td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">出版社 :</td>
		    <td width="28%"><input type="text" name="bookman"
		    size="20"></td>
		    <td width="58%" align="center"><font color="#FF0000">请输入图书出版社</font></td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">入库数量: </td>
		    <td width="28%"><input type="text" name="onSaleNum" size="20"></td>
		    <td width="58%" align="center"><font color="#FF0000">请输入图书入库数量</font></td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">现有库存:</td>
		    <td width="28%"><input type="text" name="remainNum" size="20"></td>
		    <td width="58%" align="center"><font color="#FF0000">请输入现有图书数量</font></td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">上架时间: </td>
		    <td width="28%"><input type="text" name="onSaleDate" size="20"></td>
		    <td width="58%" align="center"><font color="#FF0000">图书上架时间</font></td>
		  </tr>
		  <tr>
		    <td width="14%" align="right">图书简介:</td>
		    <td width="28%"> <textarea name="introduction" cols="17"
		    wrap="VIRTUAL" rows="3"></textarea></td>
		    <td width="58%" align="center">请输入图书简介</td>
		  </tr>
		  <tr>
		    <td width="100%" align="center" colspan="3"><table>
		      <tr>
		        <td>
		          <p><input type="submit" value="提交"> </p>
		     
		        </td>
		        <td>
					<input type="button" value="取消" onclick="">
		        </td>
		      </tr>
		    </table>
		    </td>
		  </tr>
		</table>
	</form>
  </body>
</html>
