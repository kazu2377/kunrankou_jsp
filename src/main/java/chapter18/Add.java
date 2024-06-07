package chapter18;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter18/add"})
public class Add extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		String name="name";
		String value="value";
		Cookie cookie=new Cookie(name, value);
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
	}
}
