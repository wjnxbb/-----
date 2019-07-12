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
 * Servlet implementation class addGoods
 */
@WebServlet("/addGoods")
public class addGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addGoods() {
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
		String carName = request.getParameter("carName");
		String ID = request.getParameter("ID");
		String grade = request.getParameter("grade");
		String year = request.getParameter("year");
		String price = request.getParameter("price");
		String arti = request.getParameter("arti");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
			Connection con = DriverManager.getConnection(url, "root", "1234");//û���û����������ʱ��ֱ��Ϊ��
			Statement sta = con.createStatement();
			
			String sql = "insert into car (name,id,grade,year,text,price,state) values(?,?,?,?,?,?,?)"; // ����һ��sql���
            // ����һ��Statment����
            PreparedStatement ps = con.prepareStatement(sql);

            // Ϊsql����е�һ���ʺŸ�ֵ
            ps.setString(1,carName);
            // Ϊsql����еڶ����ʺŸ�ֵ
            ps.setString(2,ID);
            // Ϊsql����е������ʺŸ�ֵ
            ps.setString(3,grade);
            // Ϊsql����е��ĸ��ʺŸ�ֵ
            ps.setString(4,year);
            ps.setString(5,arti);
            ps.setString(6,price);
            ps.setString(7,"1");
            // ִ��sql���
            ps.executeUpdate();
            // �ر����ݿ����Ӷ���
            con.close();
            
            System.out.println("ע��ɹ���");

			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("main2.jsp");
		
		
		
	}

}
