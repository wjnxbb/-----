package User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet(name="login",urlPatterns="/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		System.out.println("登录中..");
		String userName = request.getParameter("userName");
		String password  = request.getParameter("password");
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName就是刚刚添加的数据源名称
			Connection con = DriverManager.getConnection(url, "root", "1234");//没有用户名和密码的时候直接为空
			
			 String strSql = "select password from user where userName = ? ";
		        //5.准备PreparedStatement--查询窗口，把sql语句放到查询窗口中执行
		        PreparedStatement ps = con.prepareStatement(strSql);
		       
		        ps.setString(1,userName);
		        //6.处理结果集ResultSet
		        ResultSet rs = ps.executeQuery();
		        while(rs.next())
		        {
		            password = rs.getString("password");
		            System.out.println(password);
		        }
		        //7.清理资源
		        rs.close();
		        ps.close();
		        con.close();
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
