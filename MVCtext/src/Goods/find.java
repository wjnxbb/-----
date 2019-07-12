package Goods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class find
 */
@WebServlet("/find")
public class find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public find() {
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
			String fin = request.getParameter("findcondition");
			System.out.println(fin);
			ArrayList<goods> list = new ArrayList<goods>();
			//			goods[] g new goods[100];
				response.setCharacterEncoding("UTF-8");
//				for(int i=0;i<g.length;i++) {
//					g[i] = new goods();
//				}
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/shopdemo?useUnicode=true&characterEncoding=UTF-8&useSSL=false";//databaseName���Ǹո���ӵ�����Դ����
				Connection con = DriverManager.getConnection(url, "root", "1234");//û���û����������ʱ��ֱ��Ϊ��
				
				 String strSql = "select * from goods where name =?";
				 PreparedStatement ps = con.prepareStatement(strSql);
			       
			        ps.setString(1,fin);
			        ResultSet rs = ps.executeQuery();
			        int i =0;
			        
			        while (rs.next()) {
						goods g1 = new goods();
						g1.setGrade(rs.getNString("grade"));
						g1.setName(rs.getString("name"));
						g1.setPrice(rs.getFloat("price"));
						g1.setText(rs.getString("text"));
						g1.setYear(rs.getString("year"));
						g1.setId(rs.getString("id"));
						list.add(g1);// 把一个商品加入集合
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
			
			
			request.setAttribute("list", list);				//��user������ӵ�request������
			//������ת����registerSuccess.jspҳ��
			request.getRequestDispatcher("look.jsp").forward(request, response);
			
		
		
	}

}
