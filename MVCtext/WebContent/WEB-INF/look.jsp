<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Goods.goods"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览商品</title>
</head>
<body>


<div align="center">
<h2>网上商城</h2>
<table  cellSpacing="1" cellPadding="1" width="760" align="center" border="0">
<tr valign="bottom">

<td><A href="look"><font size=2>浏览商品</font></A></td>
<td><A href="find.jsp"><font size=2>查询商品</font></A></td>
<td><A href="exit2.jsp"><font size=2>退出登录</font></A></td>
<td><A href="main1.jsp"><font size=2>返回主页</font></A></td>
</tr>
</Font>
</table>
</div>

<%	
	List<goods> list = (List<goods>)request.getAttribute("list");
out.write("<font size = 2>");
String id ;
if(list==null){
	out.write("二手车售出！");

}
else if(list!=null){
	for(goods g: list){
	id = g.getId();
		out.write("品牌:"+g.getGrade()+"    ");
		out.write("<h>"+"型号："+g.getName()+"    "+"年份："+g.getYear()+"</h>");
		out.write("<h1>"+"描述:"+g.getText()+"</h>");
		
		
		out.write("<p><font color='#FF0000'>商城价：¥"+g.getPrice()+"元"+"</font></p>");
		out.write("</div>");
		out.write("<td><A href="+"cart"+"?id="+id+"><font size=2>"+"加入购物车"+"</font></A></td>");
		out.write("                          ");
		//out.write("<td><A href="+"order"+"?id="+id+"><font size=2>"+"立即购买"+"</font></A></td>");
		out.write("<br/>");
		
	}
}




%>

</body>
</html>