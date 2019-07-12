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
		response.setCharacterEncoding("UTF-8");
		
		
		
		
		System.out.println("��¼��..");
		String userName = request.getParameter("userName");
		String password  = request.getParameter("password");
		String password1 = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
			Connection con = DriverManager.getConnection(url, "root", "1234");//û���û����������ʱ��ֱ��Ϊ��
			
			 String strSql = "select password from user where userName = ? ";
		        //5.׼��PreparedStatement--��ѯ���ڣ���sql���ŵ���ѯ������ִ��
		        PreparedStatement ps = con.prepareStatement(strSql);
		       
		        ps.setString(1,userName);
		        //6.��������ResultSet
		        ResultSet rs = ps.executeQuery();
		        
		        while(rs.next())
		        {
		            password1 = rs.getString("password");
		            System.out.println(password1);
		            System.out.println(password);
		        }
		        //7.������Դ
		        rs.close();
		        ps.close();
		        con.close();
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(password.equals(password1)) {
			Cookie cookie1 = new Cookie("userName",userName);
			
			response.addCookie(cookie1);
			
			response.sendRedirect("main1.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
