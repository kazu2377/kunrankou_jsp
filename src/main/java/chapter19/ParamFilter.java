package chapter19;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ParamFilter implements Filter {
	private String message;

	public void init(FilterConfig config) throws ServletException {
		message=config.getInitParameter("message");
	}

	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		out.println(message);
		chain.doFilter(request, response);
	}

	public void destroy() {}
}
