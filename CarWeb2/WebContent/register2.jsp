<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员注册</title>
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
<center>
<form action="Register2Servlet" method="post">
<table>
			<tr>
				<td>*管理员姓名：</td>
				<td>
					<input type="text"  name="adminName" id="adminName">
				</td>
			</tr>
			
			<tr>
				<td>*设置密码：</td>
				<td>
					<input type="password"  name="adminpassword" id="adminpassword">
				</td>
			</tr>
			
			<tr>
				<td>工号：</td>
				<td>
					<input type="text"  name="adminId" id="adminId">
				</td>
			</tr>
			
			<tr>
				<td>联系电话：</td>
				<td>
					<input type="text"  name="adminPhone" id="adminPhone">
				</td>
			</tr>
			
			<tr>
              
              <td><input type=submit name="regist2submit" id="submit"  value="立即注册" id="registsubmit"></td> 
              
            </tr>	
            </table>
</form>
</center>

</body>
</html>