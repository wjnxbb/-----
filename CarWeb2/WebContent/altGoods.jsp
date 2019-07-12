<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
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
<center>
<form action="addGoods" mathod = "post">
<table>
			<tr>
				<td>输入修改的车名</td>
				<td>
					<input type="text"  name="carName" id="carName">
				</td>
			</tr>
			
			<tr>
				<td>ID</td>
				<td>
					<input type="text"  name="ID" id="ID">
				</td>
			</tr>
			
			<tr>
				<td>品牌</td>
				<td>
					<input type="text"  name="grade" id="grade">
				</td>
			</tr>
			
			<tr>
				<td>年份</td>
				<td>
					<input type="text"  name="year" id="year">
				</td>
			</tr>
			
			<tr>
			<tr>
				<td>描述</td>
				<td>
					<input type="text"  name="arti" id="arti">
				</td>
			</tr>
			
			<tr>
			<tr>
				<td>价格</td>
				<td>
					<input type="text"  name="price" id="price">
				</td>
			</tr>
			
			<tr>
              
              <td><input type=submit name="addSubmit" id="submit"  value="修改" id="addSubmit"></td> 
              
            </tr>	
            </table>
</form>
</center>

</body>
</html>