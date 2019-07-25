<%@ page language="java" import="java.util.*,beans.*"
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

		<title>My JSP 'salesInfo.jsp' starting page</title>

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
		<%@include file="adminPageHead.html"%>
			<table width=750>
				<tr>
					<td width="180" valign=top>
						<jsp:include page="adminPageLeft.jsp" flush="true"></jsp:include>
					</td>

					<td width=420>
						<table>
							<tr>
								<td align="center" colspan=5>
									<font size=5>图书销售信息</font>
								</td>
							</tr>
							<tr>
								<td width=84>
									编号
								</td>
								<td width=84>
									用户ID
								</td>
								<td width=84>
									图书ID
								</td>
								<td width=84>
									数量
								</td>
								<td width=84>
									总价
								</td>
							</tr>

							<%
								ArrayList records = (ArrayList) request.getAttribute("records");
								for (Iterator it = records.iterator(); it.hasNext();) {
									TradeRecord tr = (TradeRecord) it.next();
							%>
							<tr>
								<td>
									<%=tr.getId()%>
								</td>
								<td>
									<%=tr.getUserId()%>
								</td>
								<td>
									<%=tr.getBookId()%>
								</td>
								<td>
									<%=tr.getTradeNum()%>
								</td>
								<td>
									<%=tr.getSum()%>
								</td>
							</tr>
							<%
							}
							%>

						</table>
					</td>
				</tr>
				
			</table>
			<jsp:include flush="true" page="../userView/public/buttom.jsp"></jsp:include>
		</center>
	</body>
</html>
