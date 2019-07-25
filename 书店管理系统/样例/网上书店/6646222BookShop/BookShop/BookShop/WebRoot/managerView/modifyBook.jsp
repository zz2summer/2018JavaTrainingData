<%@ page language="java" import="java.util.*,beans.*,dao.*"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			BookDAO bookdao = new BookDAO();
			Book book = bookdao.querryUseId(bookId);

			BookCategoryDAO bcdao = new BookCategoryDAO();
			ArrayList categoryList = bcdao.querryAllCategory();
			Iterator iter = categoryList.iterator();
			int i = 1;
		%>
		<form name="a" onSubmit="return CheckForm()" action="/BookShop/servlet/Admin?requestType=modifyBook&bookId=<%= bookId %>"  method="post">
			<table width="100%">
				<tr>
					<td width="100%" align="center" colspan="2">
						修改图书信息
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						图书名称:
						<input type="text" name="name" value="<%=book.getName()%>"
							size="20">
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">请输入图书名称</font>
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						图书类别:
						<select name="categoryId" value="<%=book.getCategoryId()%>"
							size="1">
							<%
									while (iter.hasNext()) {
									BookCategory bc = (BookCategory) iter.next();
							%>
							<option value="<%=i++%>">
								<%=bc.getName()%>
							</option>
							<%
							}
							%>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</select>
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">请输入图书类别</font>
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						图书价格:
						<input type="text" name="price" value="<%=book.getPrice()%>"
							size="20">
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">请输入图书价格</font>
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						图书作者:
						<input type="text" name="author" value="<%=book.getAuthor()%>"
							size="20">
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">请输入图书作者</font>
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						出版社 :&nbsp;&nbsp;
						<input type="text" name="bookman" value="<%=book.getBookman()%>"
							size="20">
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">请输入图书出版社</font>
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						入库数量:
						<input type="text" name="onSaleNum"
							value="<%=book.getOnSaleNum()%>" size="20">
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">请输入图书入库数量</font>
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						现有库存:
						<input type="text" name="remainNum"
							value="<%=book.getRemainNum()%>" size="20">
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">请输入现有图书数量</font>
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						上架时间:
						<input type="text" name="onSaleDate"
							value="<%=book.getOnSaleDate()%>" size="20">
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">图书上架时间</font>
					</td>
				</tr>
				<tr>
					<td width="68%" align="center">
						图书简介:
						<textarea name="introduction" cols="17" rows="3"><%=book.getIntroduction()%></textarea>
					</td>
					<td width="32%" align="center">
						<font color="#FF0000">请输入图书简介</font>
					</td>
				</tr>
				<tr>
					<td width="100%" align="center" colspan="2">
						<table>
							<tr>
								<td>
									<p>
										<input type="submit" value="提交">
									</p>
								</td>
								<td>
									<p>
										<input type="submit" value="取消">
									</p>
								
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
