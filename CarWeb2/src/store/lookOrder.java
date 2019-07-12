package store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Goods.Car;

/**
 * Servlet implementation class lookOrder
 */
@WebServlet("/lookOrder")
public class lookOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lookOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = "  ";
		//获取登录用户名
		Cookie[] cookies = request.getCookies();

		

		if (cookies != null) {

			for(int i=0;i<cookies.length;i++){

				if(cookies[i].getName().equals("userName")){

					uName=cookies[i].getValue();

				}

			}

		}
		purchase[] p = new purchase[100];
		for(int i=0;i<p.length;i++) {
			p[i] = new purchase();
		}
		ArrayList<Car> list = new ArrayList<Car>();
			response.setCharacterEncoding("UTF-8");
	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
			Connection con = DriverManager.getConnection(url, "root", "1234");
			 String strSql = "select * from order_ where ouName =?";
			 PreparedStatement ps = con.prepareStatement(strSql);
		       
		        ps.setString(1,uName);
		        System.out.println(uName);
		        ResultSet rs = ps.executeQuery();
		        int i =0;
		        //得到cart数组
		        while (rs.next()) {
					p[i].setCreatTime(rs.getString("ocreatTime"));
					p[i].setGoodsId(rs.getString("ogoodsId"));
					i++;
				}
		        
		        
		       
		        rs.close();
		        ps.close();
		        con.close();
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null ;
		
		//遍历cart数组，查询汽车信息
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
		Connection con = DriverManager.getConnection(url, "root", "1234");
		 String strSql = "select * from car where id =?";
		 PreparedStatement ps = con.prepareStatement(strSql);
	       
		 
		 for(int j = 0;j<p.length;j++) {
			 if(p[j]!=null) {
				 ps.setString(1,p[j].getGoodsId());
			        
			         rs = ps.executeQuery();
			        int i =0;
			        //得到cart数组
			        while (rs.next()) {
						Car car = new Car();
						car.setGrade(rs.getNString("grade"));
						car.setName(rs.getString("name"));
						car.setPrice(rs.getFloat("price"));
						car.setText(rs.getString("text"));
						car.setYear(rs.getString("year"));
						car.setId(rs.getString("id"));
						list.add(car);// 把一个商品加入集合
					} 
			 }
	       
	        
	        
		 }
	        rs.close();
	        ps.close();
	        con.close();
	
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		for(int i=0;i<p.length;i++) {
			System.out.println(p[i].getGoodsId());
		}
		request.setAttribute("list", list);				
		request.getRequestDispatcher("lookOrder.jsp").forward(request, response);
		
	}

}
