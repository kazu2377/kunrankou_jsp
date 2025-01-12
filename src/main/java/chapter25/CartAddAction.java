package chapter25;

import java.util.ArrayList;
import java.util.List;

import bean.Item;
import bean.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CartAddAction extends Action {

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

        // カートの取得または初期化
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Item>();
            session.setAttribute("cart", cart);
        }

        // カート内に既に存在する商品の数量を更新
        for (Item i : cart) {
            if (i.getProduct().getId() == id) {
                i.setCount(quantity); // 追加ではなく数量を上書き
                return "cart.jsp";
            }
        }

        // カートに存在しない場合、新規に商品を追加
        List<Product> list = (List<Product>) session.getAttribute("list");
        if (list != null) {
            for (Product p : list) {
                if (p.getId() == id) {
                    Item i = new Item();
                    i.setProduct(p);
                    i.setCount(quantity); // 指定された数量で設定
                    cart.add(i);
                    break;
                }
            }
        }

        return "cart.jsp";
    }
}

//package chapter25;
//
//import bean.Item;
//import bean.Product;
//import tool.Action;
//import jakarta.servlet.http.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CartAddAction extends Action {
//
//	@SuppressWarnings("unchecked")
//	public String execute(
//		HttpServletRequest request, HttpServletResponse response
//	) throws Exception {
//
//		HttpSession session=request.getSession();
//
//		int id=Integer.parseInt(request.getParameter("id"));
//		
//		List<Item> cart=(List<Item>)session.getAttribute("cart");
//		if (cart==null) {
//			cart=new ArrayList<Item>();
//			session.setAttribute("cart", cart);
//		}
//
//		for (Item i : cart) {
//			if (i.getProduct().getId()==id) {
//				i.setCount(i.getCount()+1);
//				return "cart.jsp";
//			}
//		}
//
//		List<Product> list=(List<Product>)session.getAttribute("list");
//		for (Product p : list) {
//			if (p.getId()==id) {
//				Item i=new Item();
//				i.setProduct(p);
//				i.setCount(1);
//				cart.add(i);
//			}
//		}
//		return "cart.jsp";
//	}
//}
