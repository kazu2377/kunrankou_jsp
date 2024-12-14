package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/example/exampl_test" })
public class example extends HttpServlet {

	private BufferedWriter writer;

    @Override
    public void init() throws ServletException {
        try {
            writer = new BufferedWriter(new FileWriter("log.txt", true));
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");
        synchronized(this) { // 同期化ブロックで保護
            writer.write(message);
            
            try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			// TODO 自動生成された catch ブロック
    			e.printStackTrace();
    		}
            
            writer.newLine();
            writer.flush();
        }
        response.getWriter().println("メッセージを書き込みました");
    }

    @Override
    public void destroy() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            // ログ出力
        }
    }

}
