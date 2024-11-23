package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Page;

@WebServlet(urlPatterns = { "/chapter17/cart-add" })
public class CartAdd extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));

		HttpSession session = request.getSession();

		List<Product> cart = (List<Product>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<Product>();
		}

		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		cart.add(p);

		session.setAttribute("cart", cart);

		out.println("カートに商品を追加しました。");
		Page.footer(out);
	}
}
