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
		//判断是否注册成功的状态值0--失败  1--成功
		int i=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/carweb?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName就是刚刚添加的数据源名称
			Connection con = DriverManager.getConnection(url, "root", "1234");//没有用户名和密码的时候直接为空
			Statement sta = con.createStatement();
			System.out.println("数据库连接成功！");
			String sql = "insert into user (userName,password,userEmail,userPhone) values(?,?,?,?)"; // 生成一条sql语句
            // 创建一个Statment对象
            PreparedStatement ps = con.prepareStatement(sql);

            // 为sql语句中第一个问号赋值
            ps.setString(1,userName);
            // 为sql语句中第二个问号赋值
            ps.setString(2,password);
            // 为sql语句中第三个问号赋值
            ps.setString(3,userEmail);
            // 为sql语句中第四个问号赋值
            ps.setString(4,userPhone);
            // 执行sql语句
            ps.executeUpdate();
            // 关闭数据库连接对象
            con.close();
            i=1;
            System.out.println("注册成功！");

			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	
		
//		User user = new User();
//		user.setPassword(password);
//		user.setUserName(userName);
//		//response.sendRedirect("index.jsp");
//		request.setAttribute("User", user);				//将user对象添加到request对象中
//		//将请求转发到logininfo.jsp页面
		
		//成功注册
		if(i==1) {
			User user = new User();
			user.setPassword(password);
			user.setUserName(userName);
			user.setUserEmail(userEmail);
			user.setUserPhone(userPhone);
			//response.sendRedirect("index.jsp");
			request.setAttribute("User", user);				//将user对象添加到request对象中
			//将请求转发到registerSuccess.jsp页面
			request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("registerFail.jsp");
		}
	}

}