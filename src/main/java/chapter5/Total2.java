package chapter5;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter5/total2"})
public class Total2 extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		try {
			int price=Integer.parseInt(request.getParameter("price"));
			int count=Integer.parseInt(request.getParameter("count"));
			int delivery=Integer.parseInt(request.getParameter("delivery"));

			Page.header(out);
			out.println(price+"円×");
			out.println(count+"個＋");
			out.println("送料"+delivery+"円＝");
			out.println((price*count+delivery)+"円");
			Page.footer(out);
		} catch (NumberFormatException e) {
			out.println("数値を入力してください。");
		}
	}
}