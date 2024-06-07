package chapter15;

import bean.Product;
import dao.ProductDAO;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter15/insert"})
public class Insert extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			String name=request.getParameter("name");
			int price=Integer.parseInt(request.getParameter("price"));

			Product p=new Product();
			p.setName(name);
			p.setPrice(price);

			ProductDAO dao=new ProductDAO();
			int line=dao.insert(p);

			if (line>0) {
				out.println("追加に成功しました。");
			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
