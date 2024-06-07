//package chapter10;
//
//import java.io.IOException;
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//
//@WebFilter("/*")
//public class TimeFilter implements Filter {
//
//	public void doFilter(
//		ServletRequest request, ServletResponse response,
//		FilterChain chain
//	) throws IOException, ServletException {
//		long time=System.currentTimeMillis();
//		chain.doFilter(request, response);
//		time=System.currentTimeMillis()-time;
//		System.out.println("Time:"+time+"ms");
//	}
//
//	public void init(FilterConfig config) {}
//	public void destroy() {}
//}
