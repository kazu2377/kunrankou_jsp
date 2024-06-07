package chapter15;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter15/nobean"})
public class NoBean extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		int id=1;
		String name="まぐろ";
		int price=100;

		out.println(id);
		out.println("：");
		out.println(name);
		out.println("：");
		out.println(price);

		Page.footer(out);
	}
}
