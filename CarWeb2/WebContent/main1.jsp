<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
<div align="center">
<h2>网上车城</h2>
<table  cellSpacing="1" cellPadding="1" width="760" align="center" border="0">
<tr valign="bottom">

<td><A href="lookOrder"><font size=2>查看订单</font></A></td>
<td><A href="lookPurchase"><font size=2>查看购物车</font></A></td>
<td><A href="lookCar"><font size=2>浏览二手车</font></A></td>
<td><A href="findCar.jsp"><font size=2>查询二手车</font></A></td>
<td><A href="modifyRegister.jsp"><font size=2>修改注册信息</font></A></td>
<td><A href="modifyPassword.jsp"><font size=2>修改密码</font></A></td>
<td><A href="exit2.jsp"><font size=2>退出登录</font></A></td>
<td><A href="main1.jsp"><font size=2>返回主页</font></A></td>
</tr>
</Font>
</table>
</div>

<%

		Cookie[] cookies = request.getCookies();

		String user ="";

		

		if (cookies != null) {

			for(int i=0;i<cookies.length;i++){

				if(cookies[i].getName().equals("userName")){

					user=cookies[i].getValue();

				}

			}

		}

	%>

	用户名 : <%=user %><br/>

	




</body>
</html>