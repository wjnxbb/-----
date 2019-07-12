package User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(name="RegisterServlet",urlPatterns="/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String password = request.getParameter("password");
		System.out.println(password);
		String userEmail = request.getParameter("userEmail");
		System.out.println(userEmail);
		String userPhone = request.getParameter("userPhone");
		System.out.println(userPhone);
		//�ж��Ƿ�ע��ɹ���״ֵ̬0--ʧ��  1--�ɹ�
		int i=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
			Connection con = DriverManager.getConnection(url, "root", "1234");//û���û����������ʱ��ֱ��Ϊ��
			Statement sta = con.createStatement();
			System.out.println("���ݿ����ӳɹ���");
			String sql = "insert into user (userName,password,userEmail,userPhone) values(?,?,?,?)"; // ����һ��sql���
            // ����һ��Statment����
            PreparedStatement ps = con.prepareStatement(sql);

            // Ϊsql����е�һ���ʺŸ�ֵ
            ps.setString(1,userName);
            // Ϊsql����еڶ����ʺŸ�ֵ
            ps.setString(2,password);
            // Ϊsql����е������ʺŸ�ֵ
            ps.setString(3,userEmail);
            // Ϊsql����е��ĸ��ʺŸ�ֵ
            ps.setString(4,userPhone);
            // ִ��sql���
            ps.executeUpdate();
            // �ر����ݿ����Ӷ���
            con.close();
            i=1;
            System.out.println("ע��ɹ���");

			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	
		
//		User user = new User();
//		user.setPassword(password);
//		user.setUserName(userName);
//		//response.sendRedirect("index.jsp");
//		request.setAttribute("User", user);				//��user������ӵ�request������
//		//������ת����logininfo.jspҳ��
		
		//�ɹ�ע��
		if(i==1) {
			User user = new User();
			user.setPassword(password);
			user.setUserName(userName);
			user.setUserEmail(userEmail);
			user.setUserPhone(userPhone);
			//response.sendRedirect("index.jsp");
			request.setAttribute("User", user);				//��user������ӵ�request������
			//������ת����registerSuccess.jspҳ��
			request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("registerFail.jsp");
		}
	}

}