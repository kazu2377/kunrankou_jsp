package chapter23;

import bean.Product;
import dao.ProductDAO;
import tool.Action;
import jakarta.servlet.http.*;
import java.util.List;

public class InsertAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		String name=request.getParameter("name");
		Integer price=Integer.parseInt(request.getParameter("price"));

		Product p=new Product();
		p.setName(name);
		p.setPrice(price);
		ProductDAO dao=new ProductDAO();
		dao.insert(p);

		List<Product> list=dao.search("");
		request.setAttribute("list", list);

		return "list.jsp";
	}
}
