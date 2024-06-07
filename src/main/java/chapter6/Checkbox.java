package chapter6;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter6/checkbox"})
public class Checkbox extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String[] genre=request.getParameterValues("genre");

		Page.header(out);
		if (genre!=null) {
			for (String item : genre) {
				out.println("「"+item+"」");
			}
			out.println("に関するお買い得情報をお送りします。");
		} else {
			out.println("お買い得情報はお送りしません。");
		}
		Page.footer(out);
	}
}
