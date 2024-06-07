package chapter19;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter19/attribute3"})
public class Attribute3 extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		ServletContext context=getServletContext();

		String debug=(String)context.getAttribute("debug");
		if (debug.equals("yes")) {
			out.println("<p>デバッグモードで実行します。</p>");
		}

		int memory=Integer.parseInt(
			(String)context.getAttribute("memory"));
		if (memory<1000000) {
			out.println("<p>省メモリモードで実行します。</p>");
		}

		Page.footer(out);
	}
}
