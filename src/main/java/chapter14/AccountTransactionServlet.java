package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = { "/chapter14/accountTransaction" })
public class AccountTransactionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        String action = request.getParameter("action"); // "deposit" または "withdraw"
        String accountIdStr = request.getParameter("accountId");
        String amountStr = request.getParameter("amount");

        if (action == null || accountIdStr == null || amountStr == null) {
            out.println("必要なパラメータが不足しています。");
            Page.footer(out);
            return;
        }

        int accountId;
        double amount;

        try {
            accountId = Integer.parseInt(accountIdStr);
            amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                throw new NumberFormatException("金額は正の数でなければなりません。");
            }
        } catch (NumberFormatException e) {
            out.println("無効なパラメータ: " + e.getMessage());
            Page.footer(out);
            return;
        }

        Connection con = null;
        PreparedStatement selectStmt = null;
        PreparedStatement updateStmt = null;
        ResultSet rs = null;

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
            con = ds.getConnection();

            // トランザクション開始
            con.setAutoCommit(false);
            // 隔離レベルを設定（必要に応じて変更可能）
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            // 口座を取得（FOR UPDATE を使用して悲観的ロック）
            String selectSql = "SELECT balance FROM account WHERE account_id = ? FOR UPDATE";
            selectStmt = con.prepareStatement(selectSql);
            selectStmt.setInt(1, accountId);
            rs = selectStmt.executeQuery();

            if (!rs.next()) {
                con.rollback();
                out.println("指定された口座が存在しません。");
                return;
            }

            double currentBalance = rs.getDouble("balance");
            double newBalance;

            if ("deposit".equalsIgnoreCase(action)) {
                newBalance = currentBalance + amount;
            } else if ("withdraw".equalsIgnoreCase(action)) {
                if (currentBalance < amount) {
                    con.rollback();
                    out.println("残高不足です。");
                    return;
                }
                newBalance = currentBalance - amount;
            } else {
                con.rollback();
                out.println("無効なアクションです。");
                return;
            }

            // 口座残高を更新
            String updateSql = "UPDATE account SET balance = ? WHERE account_id = ?";
            updateStmt = con.prepareStatement(updateSql);
            updateStmt.setDouble(1, newBalance);
            updateStmt.setInt(2, accountId);
            int updatedRows = updateStmt.executeUpdate();

            if (updatedRows != 1) {
                con.rollback();
                out.println("口座の更新に失敗しました。");
                return;
            }

            // トランザクションコミット
            con.commit();

            out.println("トランザクションが成功しました。<br>");
            out.println("新しい残高: " + newBalance);

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace(out);
            }
            e.printStackTrace(out);
        } finally {
            // リソースのクローズ
            try {
                if (rs != null)
                    rs.close();
                if (selectStmt != null)
                    selectStmt.close();
                if (updateStmt != null)
                    updateStmt.close();
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace(out);
            }
        }

        Page.footer(out);
    }
}
