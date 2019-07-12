package User;

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
 * Servlet implementation class modifyPassword
 */
@WebServlet("/modifyPassword")
public class modifyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyPassword() {
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
		
		response.setCharacterEncoding("UTF-8");
		
		Cookie[] cookies = request.getCookies();

		String userName ="";

		

		if (cookies != null) {

			for(int i=0;i<cookies.length;i++){

				if(cookies[i].getName().equals("userName")){

					userName=cookies[i].getValue();

				}

			}

		}
		String password=null;
		password=request.getParameter("password");
		System.out.println("旧密码："+password);
		String nPassword1=null;
		nPassword1 = request.getParameter("nPassword1");
		System.out.println("新密码："+nPassword1);
		String nPassword2=null;
		nPassword2 = request.getParameter("nPassword2");
		System.out.println("确认密码："+nPassword2);
		String password1 = null;
		
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
		             password1 = rs.getString("password");
		            System.out.println(password1);
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
		if(!(password.equals(password1))) {
			response.sendRedirect("modifyPasswordFail.jsp");
		}
		else if(!(nPassword1.equals(nPassword2))) {
			response.sendRedirect("modifyPasswordFail.jsp");
		}
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName就是刚刚添加的数据源名称
				Connection con = DriverManager.getConnection(url, "root", "1234");//没有用户名和密码的时候直接为空
				
				 String strSql = "UPDATE user SET password=? WHERE userName=?";
			        
			        PreparedStatement ps = con.prepareStatement(strSql);
			       
			        ps.setString(1,nPassword1);
			        ps.setString(2, userName);
//			        6.处理结果集ResultSet
			        ps.executeUpdate();
			        
//			        
//			        while(rs.next())
//			        {
//			             password1 = rs.getString("password");
//			            System.out.println(password1);
//			            System.out.println(password);
//			        }
			        //7.清理资源
			        //rs.close();
			        ps.close();
			        con.close();
			
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				response.sendRedirect("login.jsp");
			}
			
		}

		
	}

}
