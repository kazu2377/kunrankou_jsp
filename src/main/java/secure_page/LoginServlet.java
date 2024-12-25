package secure_page;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/secure_page/login") // "/login" ページにアクセスする
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 簡易的な認証チェック
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("user".equals(username) && "password".equals(password)) {
            // 認証成功 → セッションにユーザー情報を保存
            request.getSession().setAttribute("authenticatedUser", username);
            response.sendRedirect(request.getContextPath() + "/secure/data");
        } else {
            // 認証失敗 → エラーメッセージを返す
            response.getWriter().println("ログイン失敗: ユーザー名またはパスワードが正しくありません");
        }
    }
}
