<%@ page language="java" import="java.util.*,beans.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 功能：用户注册界面 -->
<!-- 作者：CuteCode -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); %>

 <script language="javascript">
 	function CheckForm(){
 	if(document.a.username.value.length == 0){
 		alert("请输入用户名！");
 		document.a.username.focus();
 	}
 	else if(document.a.password.value.length==0){
 		alert("请输入密码！");
 		document.a.password.focus();
 	}else if(document.a.realname.value.length==0){
 	
 		alert("请输入真实姓名!");
 		document.a.realname.focus();
 	}else if(document.a.age.value.length==0){
 	
 		alert("请输入您的年龄");
 		document.a.age.focus();
 	}else if(document.a.connectnumber.value.length==0){
 	
 		alert("请输入您的联系方式");
 		document.a.connectnumber.focus();
 	}else if(document.a.address.value.length==0){
 	
 		alert("请输入您的联系地址");
 		document.a.address.focus();
 	}else if((!document.a.gender[0].checked)&&(!document.a.gender[1].checked)){
 	
 		alert("请选择您的性别");
 		document.a.gender[0].focus();
 	}
 	else{
 		return true;
 	}
 	return false;
 }
</script>
<SCRIPT LANGUAGE=javascript RUNAT=Server>
function isEmail(strEmail) {

	if (strEmail.search(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/) != -1)
		return true;
	else{
		alert("请输入正确的Email!");
		document.a.email.focus();
		}
	
}
</SCRIPT>
  <body>
    <%@include file="public/title.jsp" %>
  <form name=a action="/BookShop/servlet/Index?requestType=register" onSubmit="return CheckForm()" method="post">
  <table width="677" height="12" align="center">
  <tr>
    <td width="673" height="12" align="center" colspan="2">用户注册</td>
  </tr>
  <tr>
    <td bgcolor="#C0C0C0" width="673" height="12" colspan="2"></td>
  </tr>
  <tr>
    <td width="466">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名: &nbsp;&nbsp; <input type="text"
    name="username"><%if(request.getAttribute("alert")!=null){%><%=request.getAttribute("alert")%><%} %></td>
    <td width="203"><small><font color="#FF0000">请输入用户名</font></small></td>
  </tr>
  <tr>
    <td width="392">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 密 码:&nbsp;&nbsp; <input
    type="password" name="password" size="20"></td>
    <td width="281"><small><font color="#FF0000">请填写密码</font></small></td>
  </tr>
  <tr>
    <td width="392">&nbsp;&nbsp;真实姓名: &nbsp; <input type="text" name="realname"
    size="20"></td>
    <td width="281"><small><font color="#FF0000">请填写您的真实姓名</font></small></td>
  </tr>
  <tr>
    <td width="283">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 性 别: &nbsp; <input
    type="radio" name="gender" value ="男">男 <input type="radio" name="gender" value ="女">女</td>
    <td width="390"><font size="2" color="#FF0000">请选择您的性别</font></td>
  </tr>
  <tr>
    <td width="283">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年 龄: &nbsp; <input
    type="text" name="age" size="20"></td>
    <td width="390"><small><font color="#FF0000">请填写您的年龄</font></small></td>
  </tr>
  <tr>
    <td width="283">&nbsp;User Email:&nbsp;&nbsp;&nbsp; <input type="text" name="email"
    size="20" onblur=isEmail(this.value)></td>
    <td width="390"><small><font color="#FF0000">请输入您常用的电子邮件</font></small></td>
  </tr>
  <tr>
    <td width="283">&nbsp;联系方式:&nbsp;&nbsp;&nbsp; <input type="text" name="connectnumber"
    size="20"></td>
    <td width="390"><font color="#FF0000"><small>请输入您的联系方式，以便我们及时联系您</small></font></td>
  </tr>
  <tr>
    <td width="283">&nbsp;联系地址:&nbsp;&nbsp;&nbsp; <input type="text" name="address"
    size="20"></td>
    <td width="390"><font color="#FF0000"><small>请填写您的地址，以便我们发货给您</small></font></td>
  </tr>
  <tr>
    <td width="670">&nbsp;注册时间:&nbsp;&nbsp;&nbsp;&nbsp;<%Calendar c = Calendar.getInstance();
  %><%=c.get(Calendar.YEAR)%>-<%=c.get(Calendar.MONTH)%>-<%=c.get(Calendar.DATE)%> </td>
  </tr>
  <tr>
    <td width="673" height="12" align="center" colspan="2"></td>
  </tr>
  <tr>
		<td width="100%" colspan="5" align="center">
    <table>
     <tr>
	<td>
  <input type="submit" value="提交">
        </td>
        <td>
          <p><input type="button" value="取消" onClick="document.location.href='/BookShop/index.jsp'"> </p>
        </td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</form>
  <%@include file="public/buttom.jsp" %>
  </body>
</html>
