<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'addCategory.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<Script>
	function Check(){
	
		if(document.form1.categoryName.value==""){
		
			alert("请输入类别");
			document.form1.categoryName.focus();
			return false;
		}
		return true;
	}
</Script>
	</head>

	<body>

		<center>
			<table>
				<tr>
					<td colspan=2>
						<%@include file="adminPageHead.html"%>
					</td>
				</tr>
				<tr>
					<td>
						<jsp:include flush="true" page="adminPageLeft.jsp"></jsp:include>
					</td>

					<td align="center">
						<form name="form1" onSubmit="return Check()" action="/BookShop/servlet/Admin?requestType=addCategory"
							method="post">
							<table border=0 width="263" height="124">
								<tr>
									<td width="200" height="41" colspan=3>
										<font size=5>
												新增图书类别
											 </font>
									</td>
								</tr>
								<tr>
									<td width="100" height="58">
										<font size=3>图书类别:</font>
									</td>
									<td width="60%" height="58" colspan=2>
										<input type="text" name="categoryName" size="20"></input>
									</td>
								</tr>
								
								<tr><td></td>
								<td>
									<input type="submit" value="新增" name="add">
								
									<input type="reset" value="重置" name="reset">
								</td></tr>
								</table>
						</form>
					</td>
				</tr>
				<tr>
					<td align = "center" colspan =2>
						<%@include file="../userView/public/buttom.jsp"%>
					</td>
				</tr>
			</table>
			

		</center>
	</body>
</html>
