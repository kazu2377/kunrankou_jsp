package chapter25;

import bean.Item;
import dao.PurchaseDAO;
import tool.Action;
import jakarta.servlet.http.*;
import java.util.List;

public class PurchaseAction extends Action {
	@SuppressWarnings("unchecked")
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String name=request.getParameter("name");
		String address=request.getParameter("address");
		if (name.isEmpty() || address.isEmpty()) {
			return "purchase-error-empty.jsp";
		}

		PurchaseDAO dao=new PurchaseDAO();
		List<Item> cart=(List<Item>)session.getAttribute("cart");
		if (cart==null || !dao.insert(cart, name, address)) {
			return "purchase-error-insert.jsp";
		}

		session.removeAttribute("cart");
		return "purchase-out.jsp";
	}
}
