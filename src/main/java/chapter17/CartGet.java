package chapter17;

import bean.Product;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter17/cart-get"})
public class CartGet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		HttpSession session=request.getSession();

		List<Product> cart=(List<Product>)session.getAttribute("cart");

		for (Product p : cart) {
			out.println("<p>");
			out.println(p.getName());
			out.println("：");
			out.println(p.getPrice());
			out.println("</p>");
		}

		Page.footer(out);
	}
}
