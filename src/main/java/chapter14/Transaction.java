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

@WebServlet(urlPatterns={"/chapter14/transaction"})
public class Transaction extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();

			String name=request.getParameter("name");
			int price=Integer.parseInt(request.getParameter("price"));

			con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            
            int defaultIsolationLevel = con.getTransactionIsolation();
            String isolationLevelName;
            switch (defaultIsolationLevel) {
                case Connection.TRANSACTION_READ_UNCOMMITTED:
                    isolationLevelName = "READ UNCOMMITTED";
                    break;
                case Connection.TRANSACTION_READ_COMMITTED:
                    isolationLevelName = "READ COMMITTED";
                    break;
                case Connection.TRANSACTION_REPEATABLE_READ:
                    isolationLevelName = "REPEATABLE READ";
                    break;
                case Connection.TRANSACTION_SERIALIZABLE:
                    isolationLevelName = "SERIALIZABLE";
                    break;
                default:
                    isolationLevelName = "UNKNOWN";
            }
            System.out.println("Default Transaction Isolation Level: " + isolationLevelName);
            
            
			PreparedStatement st=con.prepareStatement(
				"insert into product(name, price) values(?, ?)");
			st.setString(1, name);
			st.setInt(2, price);
			st.executeUpdate();

			st=con.prepareStatement(
				"select * from product where name=?");
			st.setString(1, name);
			ResultSet rs=st.executeQuery();
			int line=0;
			while (rs.next()) {
				line++;
			}

            // トランザクション1を一定時間待機
//            System.out.println("トランザクション1が待機しています...");
//            Thread.sleep(10000);  // 10秒間待機
//            System.out.println("トランザクション1が待機終了しました。");
            
			if (line==1) {
				con.commit();
				out.println("商品を登録しました。");
			} else {
				con.rollback();
				out.println("商品は既に登録されています。");
			}

			con.setAutoCommit(true);

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
