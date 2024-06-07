package chapter25;

import bean.Item;
import tool.Action;
import jakarta.servlet.http.*;
import java.util.List;

public class CartRemoveAction extends Action {
	@SuppressWarnings("unchecked")
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		int id=Integer.parseInt(request.getParameter("id"));

		List<Item> cart=(List<Item>)session.getAttribute("cart");

		for (Item i : cart) {
			if (i.getProduct().getId()==id) {
				cart.remove(i);
				break;
			}
		}

		return "cart.jsp";
	}
}
