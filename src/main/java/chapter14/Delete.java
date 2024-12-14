package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter14/delete"})
public class Delete extends HttpServlet {

    public void doPost(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(
                "java:/comp/env/jdbc/book");
            Connection con = ds.getConnection();

            // 削除するIDをパラメータから取得
            int id = Integer.parseInt(request.getParameter("id"));

            // SQL文を実行
            PreparedStatement st = con.prepareStatement(
                "DELETE FROM product WHERE id = ?");
            st.setInt(1, id);
            int line = st.executeUpdate();

            if (line > 0) {
                out.println("削除に成功しました。");
            } else {
                out.println("削除対象が見つかりませんでした。");
            }

            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}
