package secure;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/secure/data") // "/secure/data" にアクセスする
public class SecureServlet extends HttpServlet {

    // サーブレット初期化時に1回だけ呼び出される
    @Override
    public void init() {
        System.out.println("サーブレットが初期化されました。");
        // 初期化処理（例：リソースのロード、データベース接続の準備など）
    }

    // HTTP GET リクエストが来たときに呼ばれる
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 実際のリクエスト処理
        response.getWriter().println("認証済みユーザーのみが見られるデータです！");
    }

    // サーブレット終了時に1回だけ呼び出される
    @Override
    public void destroy() {
        System.out.println("サーブレットが破棄される前にリソースを解放します。");
        // 終了処理（例：データベース接続のクローズ、リソースの解放）
    }

    // service() はリクエストごとに呼ばれる
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        super.service(request, response);  // 基底クラスのserviceメソッドを呼び出し
        System.out.println("リクエストを処理中...");
    }
}


//package secure;
//import java.io.IOException;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/secure/data") // "/secure/data" にアクセスする
//public class SecureServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        response.getWriter().println("認証済みユーザーのみが見られるデータです！");
//    }
//}
