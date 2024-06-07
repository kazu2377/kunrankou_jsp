package chapter5;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter5/greeting"})
public class Greeting extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String user=request.getParameter("user");

		Page.header(out);
		out.println("<p>こんにちは、"+user+"さん！</p>");
		Page.footer(out);
	}
}
