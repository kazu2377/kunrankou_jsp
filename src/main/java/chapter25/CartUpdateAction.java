package chapter25;

import java.util.List;

import bean.Item;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CartUpdateAction extends Action {

    @SuppressWarnings("unchecked")
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

        HttpSession session = request.getSession();

        // 商品IDの取得
        int id = Integer.parseInt(request.getParameter("id"));

        // 数量の取得（デフォルトは1）
        int quantity = 1;
        String quantityParam = request.getParameter("quantity");
        if (quantityParam != null && !quantityParam.isEmpty()) {
            quantity = Integer.parseInt(quantityParam);
        }

        // カートの取得します
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if (cart != null) {
            for (Item i : cart) {
                if (i.getProduct().getId() == id) {
                    i.setCount(quantity); // 数量を上書き
                    break;
                }
            }
        }

        return "cart.jsp";
    }
}
