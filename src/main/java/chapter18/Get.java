package chapter18;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter18/get"})
public class Get extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				String name=cookie.getName();
				String value=cookie.getValue();
				out.println("<p>"+name+" : "+value+"</p>");
			}
		} else {
			out.println("クッキーは存在しません");
		}

		Page.footer(out);
	}
}
