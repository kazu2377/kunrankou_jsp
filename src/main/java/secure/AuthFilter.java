package secure;

import java.io.IOException;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/secure/*") // "/secure" 以下のURLに適用される
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初期化処理（必要なら）
        System.out.println("AuthFilter: 初期化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        
        AsyncContext AsyncContexts = (AsyncContext) response;

        // セッションから認証情報を取得
        Object user = httpRequest.getSession().getAttribute("authenticatedUser");

        if (user == null) {
            // 認証されていない場合はログインページにリダイレクト
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/secure_page/login.jsp");
            System.out.println("AuthFilter: 認証されていないリクエストをリダイレクト");
        } else {
            // 認証されている場合は次の処理に進む
            System.out.println("AuthFilter: 認証済みリクエストを処理");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // リソースの解放など
        System.out.println("AuthFilter: 終了");
    }
}
