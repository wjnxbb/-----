<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询二手车</title>
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
	
	</head>
<body bgcolor = white><font size = 2><center> 
<br><br>
<table border=2>



	<center>
<form action="findCar" method="post">
<table>
			<tr>
				<td>请输入查询关键词</td>
				<td>
					<input type="text"  name="findcondition" id="findcondition">
				</td>
			</tr>
			
			<tr>
              
              <td><input type=submit name="find" id="submit"  value="🔍" id="findsubmit"></td> 
              
            </tr>	
            </table>
</form>
</center>

	
</body>
</html>