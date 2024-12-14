package chapter12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter12/request"})
public class Request extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		
		out.println("<p>Request URL<br>"+
			request.getRequestURL()+"</p>");
		out.println("<p>Host<br>"+
			request.getHeader("Host")+"</p>");
		out.println("<p>User-Agent<br>"+
			request.getHeader("User-Agent")+"</p>");
		out.println("<p>Remote Address<br>"+
			request.getRemoteAddr()+"</p>");

        // リクエストヘッダーの取得
        String accept = request.getHeader("Accept");
        String acceptEncoding = request.getHeader("Accept-Encoding");
        String acceptLanguage = request.getHeader("Accept-Language");
        String connection = request.getHeader("Connection");
        String host = request.getHeader("Host");
        String secFetchDest = request.getHeader("Sec-Fetch-Dest");
        String secFetchMode = request.getHeader("Sec-Fetch-Mode");
        String secFetchSite = request.getHeader("Sec-Fetch-Site");
        String secFetchUser = request.getHeader("Sec-Fetch-User");
        String upgradeInsecureRequests = request.getHeader("Upgrade-Insecure-Requests");
        String userAgent = request.getHeader("User-Agent");
        String secChUa = request.getHeader("sec-ch-ua");
        String secChUaMobile = request.getHeader("sec-ch-ua-mobile");
        String secChUaPlatform = request.getHeader("sec-ch-ua-platform");
        Enumeration<String> acceptHeaders = request.getHeaders("Accept-Language");
        while (acceptHeaders.hasMoreElements()) {
            String accept1 = acceptHeaders.nextElement();
            out.println("<li>" + accept + "</li>");

        }
        
        response.getWriter().println("Request Method: " + request.getMethod());
        response.getWriter().println("Request URI: " + request.getRequestURI());
        response.getWriter().println("Context Path: " + request.getContextPath());
        response.getWriter().println("Servlet Path: " + request.getServletPath());
        response.getWriter().println("Query String: " + request.getQueryString());
        response.getWriter().println("Protocol: " + request.getProtocol());
        
      
		Page.footer(out);
	}
	
	public void doPost (
			HttpServletRequest request, HttpServletResponse response
		) throws ServletException, IOException {
		
		  response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
		
//		// 1. getReader() を使用してメッセージボディを文字列データとして読み取る
//        response.getWriter().println("=== Using getReader() ===");
//        try (BufferedReader reader = request.getReader()) {
//            StringBuilder requestBody = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                requestBody.append(line).append("\n");
//            }
//            response.getWriter().println("Message Body (Text):");
//            response.getWriter().println(requestBody.toString());
//        }

        // 2. getInputStream() を使用してメッセージボディをバイナリデータとして読み取る
        response.getWriter().println("\n=== Using getInputStream() ===");
        try (ServletInputStream inputStream = request.getInputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            StringBuilder binaryData = new StringBuilder();
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                binaryData.append(new String(buffer, 0, bytesRead));
            }
            response.getWriter().println("Message Body (Binary as String):");
            response.getWriter().println(binaryData.toString());
        }
        
		  // URL情報を取得するメソッド
        response.getWriter().println("Request URL: " + request.getRequestURL());
        response.getWriter().println("Request Scheme: " + request.getScheme());
        response.getWriter().println("Server Name: " + request.getServerName());
        response.getWriter().println("Server Port: " + request.getServerPort());

        // リクエスト元の情報を取得するメソッド
        response.getWriter().println("Remote Addr: " + request.getRemoteAddr());
        response.getWriter().println("Remote Host: " + request.getRemoteHost());
        response.getWriter().println("Remote Port: " + request.getRemotePort());
        response.getWriter().println("Local Addr: " + request.getLocalAddr());
        response.getWriter().println("Local Name: " + request.getLocalName());
        response.getWriter().println("Local Port: " + request.getLocalPort());
        
        // Content-Type ヘッダーの設定
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        
        // Expires ヘッダーの設定
        response.setHeader("Expires", "Wed, 21 Oct 2025 07:28:00 GMT");
        
        // Set-Cookie ヘッダーの設定
        response.setHeader("Set-Cookie", "user=guest; Path=/; HttpOnly");
        
        // HTML出力
        response.getWriter().println("<html><body><h1>ヘッダー設定の例</h1></body></html>");
        
//		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "https://html.spec.whatwg.org/");
	}
	
		
	}

