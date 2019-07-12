package store;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
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
		
		String id = request.getParameter("id");
		String uName = "  ";
		//获取用户名
		Cookie[] cookies = request.getCookies();

		

		if (cookies != null) {

			for(int i=0;i<cookies.length;i++){

				if(cookies[i].getName().equals("userName")){

					uName=cookies[i].getValue();

				}

			}

		}
		
		Date day=new Date();    

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
String d = df.format(day);  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
			Connection con = DriverManager.getConnection(url, "root", "1234");//û���û����������ʱ��ֱ��Ϊ��
			Statement sta = con.createStatement();
			
			String sql = "insert into cart (id,uName,goodsId,creatTime) values(?,?,?,?)"; // ����һ��sql���
            // ����һ��Statment����
            PreparedStatement ps = con.prepareStatement(sql);

            // Ϊsql����е�һ���ʺŸ�ֵ
            ps.setString(1,id+id);
            // Ϊsql����еڶ����ʺŸ�ֵ
            ps.setString(2,uName);
            // Ϊsql����е������ʺŸ�ֵ
            ps.setString(3,id);
            // Ϊsql����е��ĸ��ʺŸ�ֵ
           ps.setString(4,d);
            // ִ��sql���
           
            ps.executeUpdate();
            // �ر����ݿ����Ӷ���
           

			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
			Connection con = DriverManager.getConnection(url, "root", "1234");//û���û����������ʱ��ֱ��Ϊ��
			Statement sta = con.createStatement();
			
			String sq1 = "UPDATE car SET state=0 WHERE id=?";
            // ����һ��Statment����
            PreparedStatement ps1 = con.prepareStatement(sq1);

         
            //更新状态
            
           
            ps1.setString(1, id);
            ps1.executeUpdate();
            con.close();
            

			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		OutputStream out  = response.getOutputStream();
		out.write("加入成功".getBytes());
		System.out.println("插入成功！");
		
		response.sendRedirect("lookCar.jsp");
		
	}

}
