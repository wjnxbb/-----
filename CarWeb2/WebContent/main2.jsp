<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
</head>
<body>


<div align="center">
<h2>网上车城</h2>
<table  cellSpacing="1" cellPadding="1" width="760" align="center" border="0">
<tr valign="bottom">

<td><A href="addGoods.jsp"><font size=2>增加商品</font></A></td>
<td><A href="delGoods.jsp"><font size=2>删除商品</font></A></td>
<td><A href="altGoods.jsp"><font size=2>修改商品</font></A></td>
<td><A href="exit2.jsp"><font size=2>退出登录</font></A></td>
<td><A href="main2.jsp"><font size=2>返回主页</font></A></td>

</tr>
</Font>
</table>
</div>

<%

		Cookie[] cookies = request.getCookies();

		String user ="";

		

		if (cookies != null) {

			for(int i=0;i<cookies.length;i++){

				if(cookies[i].getName().equals("adminName")){

					user=cookies[i].getValue();

				}

			}

		}

	%>

	用户名 : <%=user %><br/>

</body>
</html>