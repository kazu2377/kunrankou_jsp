package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Greetingインターフェースの定義
interface Greeting {
 void sayHello();
}
@WebServlet(urlPatterns = { "/chapter4/hello2" })
public class Hello2 extends HttpServlet {

	private final class Atai implements Greeting {
		@Override
		public void sayHello() {
		    System.out.println("HELLO");
		}
	}

	private static final String そうだ = "そうだ";

	public void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Hello!");
		out.println("こんにちは！");
		out.println(new java.util.Date());

		Math.random();
		
		
		
		test5(null);
		
		// 匿名クラスを使用して、簡単なメソッドを持つインスタンスを作成
        Greeting greeting = new Atai();

        // メソッドの実行
        greeting.sayHello();
        
	}
	
	public void test5(Object newParam)
	{
		
		int atai = 10000;
		
		int i = extracted(atai);
		final var string = そうだ;
		final String string2 = "test";
		System.out.print(atai+i + string + string2);
	}

	/**
	 * @param atai
	 * @return
	 */
	private int extracted(int atai) {
		return 100 + atai *100;
	}
	
	public void test2()
	{
		
	}
	
}
