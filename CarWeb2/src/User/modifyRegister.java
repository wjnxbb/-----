package User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class modifyRegister
 */
@WebServlet("/modifyRegister")
public class modifyRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("hhhhhh");
		Cookie[] cookies = request.getCookies();

		String userName ="";

		

		if (cookies != null) {

			for(int i=0;i<cookies.length;i++){

				if(cookies[i].getName().equals("userName")){

					userName=cookies[i].getValue();

				}

			}

		}
		System.out.println(userName);
		String newUserEmail = request.getParameter("userEmail");
		System.out.println(newUserEmail);
		String newUserPhone = request.getParameter("userPhone");
		System.out.println(newUserPhone);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
			Connection con = DriverManager.getConnection(url, "root", "1234");//û���û����������ʱ��ֱ��Ϊ��
			
			 String strSql = "UPDATE user SET  userEmail=? "+","+"userPhone=? WHERE userName=?";
		        
		        PreparedStatement ps = con.prepareStatement(strSql);
		       
		        
		        ps.setString(1, newUserEmail);
		        ps.setString(2, newUserPhone);
		        ps.setString(3, userName);
//		        6.��������ResultSet
		        ps.executeUpdate();
		        
//		        
//		        while(rs.next())
//		        {
//		             password1 = rs.getString("password");
//		            System.out.println(password1);
//		            System.out.println(password);
//		        }
		        //7.������Դ
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
