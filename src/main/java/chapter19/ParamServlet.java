package chapter19;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ParamServlet extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		ServletConfig config=getServletConfig();
		message=config.getInitParameter("message");
	}
	
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println(message);
	}
}
