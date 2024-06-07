package chapter23;

import bean.Product;
import dao.ProductDAO;
import tool.Action;
import jakarta.servlet.http.*;
import java.util.List;

public class SearchAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		String keyword=request.getParameter("keyword");

		ProductDAO dao=new ProductDAO();
		List<Product> list=dao.search(keyword);

		request.setAttribute("list", list);

		return "list.jsp";
	}
}
