
    <%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
    
<%@ page import="Goods.Car"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看订单</title>
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
	List<Car> list = (List<Car>)request.getAttribute("list");
out.write("<font size = 2>");
String id ;
double price=0;
if(list==null){
	out.write("订单为空！");

}

else if(list!=null){
	for(Car car : list){
	id = car.getId();
		out.write("品牌:"+car.getGrade()+"    ");
		out.write("<h>"+"型号："+car.getName()+"    "+"年份："+car.getYear()+"</h>");
		out.write("<h1>"+"描述:"+car.getText()+"</h>");
		
		 price += Double.valueOf(car.getPrice());
		out.write("<p><font color='#FF0000'>商城价：¥"+car.getPrice()+"万元"+"</font></p>");
		out.write("</div>");
		out.write("<td><A href="+"removeOrder"+"?id="+id+"><font size=2>"+"取消订单"+"</font></A></td>");
		out.write("                          ");
		
		
	}
}




%>

</body>
</html>