package chapter19;

import tool.Page;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter19/attribute4"})
public class Attribute4 extends HttpServlet {

	public void init() throws ServletException {
		try {
			ServletContext context=getServletContext();
			String path=context.getRealPath("WEB-INF/setting.txt");
			FileInputStream in=new FileInputStream(path);
			Properties p=new Properties();
			p.load(in);
			in.close();
			for (String name : p.stringPropertyNames()) {
				context.setAttribute(name, p.getProperty(name));
			}
		} catch (IOException e) {
			throw new ServletException(
				"ファイルの読み込みに失敗しました。");
		}
	}

	public void doGet (
	HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		out.println("アプリケーション属性を設定しました。");
		Page.footer(out);
	}
}
