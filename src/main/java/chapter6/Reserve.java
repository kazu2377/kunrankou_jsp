package chapter6;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter6/reserve"})
public class Reserve extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String count=request.getParameter("count");
		String seat=request.getParameter("seat");

		Page.header(out);
		out.println(count+"名様で"+seat+"席のご予約を承りました。");
		for (String value : request.getParameterValues("option")) {
			out.println("「"+value+"」");
		}
		out.println("をご用意いたします。");
		Page.footer(out);
	}
}
