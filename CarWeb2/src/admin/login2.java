package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login2
 */
@WebServlet("/login2")
public class login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminName = request.getParameter("adminName");
		System.out.println(adminName);
		String adminpassword = request.getParameter("adminpassword");
		System.out.println(adminpassword);
		String password = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=ture&characterEncoding=UTF-8&useSSL=false";
			Connection con = DriverManager.getConnection(url,"root","1234");
			String strSql = "select adminpassword from admin where adminName = ?";
			PreparedStatement ps =  con.prepareStatement(strSql);
			ps.setString(1, adminName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				password = rs.getString("adminpassword");
			}
			rs.close();
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password.equals(adminpassword)) {
			Cookie cookie = new Cookie("userName",adminName);
			response.addCookie(cookie);
			response.sendRedirect("main2.jsp");
		}
		else {
			response.sendRedirect("login2.jsp");
		}
		
	}

}
