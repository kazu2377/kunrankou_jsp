package chapter16;

import bean.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter16/attribute"})
public class Attribute extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		Product p=new Product();
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);
		
		request.setAttribute("product", p);

		request.getRequestDispatcher("attribute.jsp")
			.forward(request, response);
	}
}
