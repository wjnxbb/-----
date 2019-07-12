package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DO.GoodsDO;
import dao.goodsDao;
import dao.goodsDaoImp;

/**
 * Servlet implementation class goodsListServlet
 */
@WebServlet("/goodsListServlet")
public class goodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsListServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		goodsDao g = new goodsDaoImp();
		List<GoodsDO> list = new ArrayList<GoodsDO>();
		list=g.show();
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE HTML>");
		pw.println("<HTML>");
		pw.println(" <head><title>商品列表</title></head>");
		pw.println(" <body>");
		
		pw.println("<table>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th>商品编号</th>");
		pw.println("<th>商品名</th>");
		pw.println("<th>商品数量</th>");
		pw.println("<th>商品价格</th>");
		pw.println("</tr>");
		pw.println("</thead>");
		pw.println("<tbody>");
		for(int i=0;i<list.size();i++) {
			GoodsDO goods = list.get(i);
			pw.println("<tr>");
			pw.println("<td>"+goods.getGid()+"</td>");
			pw.println("<td>"+goods.getGname()+"</td>");
			pw.println("<td>"+goods.getGstore()+"</td>");
			pw.println("<td>"+goods.getPrice()+"</td>");
		}
		pw.println("</tbody>");
		pw.println("</thead>");
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
		
		
	}

}
