<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功！</title>
</head>
<body>
<div align="center">
<h2>网上车城</h2>
<table  cellSpacing="1" cellPadding="1" width="760" align="center" border="0">
<tr valign="bottom">
<td><A href="register.jsp"><font size=2>用户注册</font></A></td>
<td><A href="login.jsp"><font size=2>用户登录</font></A></td>
<td><A href="queryOrderForm.jsp"><font size=2>查看订单</font></A></td>
<td><A href="lookPurchase.jsp"><font size=2>查看购物车</font></A></td>
<td><A href="loobCar.jsp"><font size=2>浏览二手车</font></A></td>
<td><A href="findCar.jsp"><font size=2>查询二手车</font></A></td>
<td><A href="modifyRegister.jsp"><font size=2>修改注册信息</font></A></td>
<td><A href="modifyPassword.jsp"><font size=2>修改密码</font></A></td>
<td><A href="exit2.jsp"><font size=2>退出登录</font></A></td>
<td><A href="main.jsp"><font size=2>返回主页</font></A></td>
</tr>
</Font>
</table>
</div>

<center>
<h1><Font Size = 4 color = green>注册成功！</Font></h1>
<h1>注册信息如下：</font></h1>

<tr>
			<td>用户名：</td>
			<td><%=request.getParameter("userName")%></td>
			<br/>
		</tr>
		<tr>
			<td>密码：</td>
			<td><%=request.getParameter("password")%></td>
			<br/>
			</tr>
		<tr>
			<td>电子邮箱：</td>
			<td><%=request.getParameter("userEmail")%></td>
			<br/>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td><%=request.getParameter("userPhone")%></td>
		<br/>
		</tr>
		
		
		
		

</center>


</body>
</html>