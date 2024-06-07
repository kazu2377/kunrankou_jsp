package chapter17;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter17/count"})
public class Count extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		HttpSession session=request.getSession();

		Integer count=(Integer)session.getAttribute("count");
		if (count==null) count=0;
		count++;
		session.setAttribute("count", count);

		out.println("<p>"+count+"</p>");
		out.println("<p>"+session.getId()+"</p>");
		Page.footer(out);
	}
}
