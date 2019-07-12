package admin;

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
 * Servlet implementation class Register2Servlet
 */
@WebServlet("/Register2Servlet")
public class Register2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register2Servlet() {
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
response.setCharacterEncoding("UTF-8");
		
		String adminName = request.getParameter("adminName");
		System.out.println(adminName);
		String adminpassword = request.getParameter("adminpassword");
		System.out.println(adminpassword);
		String adminId = request.getParameter("adminId");
		System.out.println(adminId);
		String adminPhone = request.getParameter("adminPhone");
		System.out.println(adminPhone);
		//�ж��Ƿ�ע��ɹ���״ֵ̬0--ʧ��  1--�ɹ�
		int i=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
			Connection con = DriverManager.getConnection(url, "root", "1234");//û���û����������ʱ��ֱ��Ϊ��
			Statement sta = con.createStatement();
			System.out.println("���ݿ����ӳɹ���");
			String sql = "insert into admin (adminName,adminpassword,adminId,adminPhone) values(?,?,?,?)"; // ����һ��sql���
            // ����һ��Statment����
            PreparedStatement ps = con.prepareStatement(sql);

            // Ϊsql����е�һ���ʺŸ�ֵ
            ps.setString(1,adminName);
            // Ϊsql����еڶ����ʺŸ�ֵ
            ps.setString(2,adminpassword);
            // Ϊsql����е������ʺŸ�ֵ
            ps.setString(3,adminId);
            // Ϊsql����е��ĸ��ʺŸ�ֵ
            ps.setString(4,adminPhone);
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

		if(i==1) {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("registerFail.jsp");
		}
		
		
	}

}
