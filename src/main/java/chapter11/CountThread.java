package chapter11;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter11/count-thread"})
public class CountThread extends HttpServlet {
	int count;

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		int i=count;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		count=i+1;
		out.println(count);

		Page.footer(out);
	}
}
