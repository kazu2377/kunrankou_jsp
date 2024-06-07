package chapter6;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns={"/chapter6/control"})
public class Control extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		Page.header(out);

		request.setCharacterEncoding("UTF-8");
		List<String> names=Collections.list(request.getParameterNames());
		for (String name : names) {
			String[] values=request.getParameterValues(name);
			for (String value : values) {
				out.println("<p>"+name+"="+value+"</p>");
			}
		}
		Page.footer(out);
	}
}
