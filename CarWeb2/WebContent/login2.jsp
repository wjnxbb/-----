<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
<div align="center">
<h2>网上车城</h2>
<table  cellSpacing="1" cellPadding="1" width="760" align="center" border="0">
<tr valign="bottom">
<td><A href="register.jsp"><font size=2>用户注册</font></A></td>
<td><A href="register2.jsp"><font size=2>管理员注册</font></A></td>
<td><A href="login.jsp"><font size=2>用户登录</font></A></td>
<td><A href="login2.jsp"><font size=2>管理员登录</font></A></td>

</tr>
</Font>
</table>
</div>
<body bgcolor=white><font size=2><center>
<br><br>
<table border=2>
<tr><th>请登录</th></tr>
<form action = "login2" method = "post">
<tr><td>管理员姓名:<input type = text name = "adminName" ></td></tr>
<tr><td>登录密码:<input type = password name = "adminpassword" ></td></tr>
</table>
<br><input type = submit name = "g" value = "登录">
</form>
</center>

</body>

</body>
</html>