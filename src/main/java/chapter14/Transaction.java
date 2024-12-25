package chapter14;
//分離レベルバージョン（テキストのサンプル

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
            // SERIALIZABLEを使用して悲観ロックと併用可能
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); 

			// 悲観ロックを使用するためのクエリ（SELECT ... FOR UPDATE ）
			PreparedStatement st=con.prepareStatement(
				"SELECT * FROM product WHERE name = ? ");
			st.setString(1, name);
			ResultSet rs=st.executeQuery();
			
			int count = 0;
			while (rs.next()) {
			    System.out.println(rs.getString(3)); // 金額
			    
	
	            
			    count++;
			}

			
			 // 2. 残高を更新
            String updateSQL = "UPDATE product SET price = ? WHERE name = ?";
            PreparedStatement updateSsttmt = con.prepareStatement(updateSQL);
             updateSsttmt.setInt(1, 900);
             updateSsttmt.setString(2, name);
            int rowsUpdated = updateSsttmt.executeUpdate();

            if (rowsUpdated != 1) {
				 System.out.println("2残高の更新に失敗しました: ");

            }
            

			System.out.println("１度目件数: " + count);
			
			
			
			 st=con.prepareStatement(
					"SELECT * FROM product WHERE name = ?");
				st.setString(1, name);
				 rs=st.executeQuery();
				 
				  count = 0;
				 while (rs.next()) {
					    System.out.println(rs.getString(3)); // 列名を指定

				     count++;
				 }

				 System.out.println("2度目件数: " + count);

			if (rs.next()) {
				// 既に商品が存在する場合はロールバック
				con.rollback();
				out.println("商品は既に登録されています。");
			} else {
				// 商品を登録
				st=con.prepareStatement(
					"INSERT INTO product(name, price) VALUES(?, ?)");
				st.setString(1, name);
				st.setInt(2, price);
				st.executeUpdate();

	            System.out.println("トランザクション1が待機しています...");
	            Thread.sleep(5000);  // 10秒間待機
	            System.out.println("トランザクション1が待機終了しました。");
				con.commit();
				out.println("商品を登録しました。");
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

//分離レベル無しバージョン（テキストのサンプル
//package chapter14;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import tool.Page;
//
//@WebServlet(urlPatterns={"/chapter14/transaction"})
//public class Transaction extends HttpServlet {
//
//	public void doPost (
//		HttpServletRequest request, HttpServletResponse response
//	) throws ServletException, IOException {
//		PrintWriter out=response.getWriter();
//		Page.header(out);
//		try {
//			InitialContext ic=new InitialContext();
//			DataSource ds=(DataSource)ic.lookup(
//				"java:/comp/env/jdbc/book");
//			Connection con=ds.getConnection();
//
//			String name=request.getParameter("name");
//			int price=Integer.parseInt(request.getParameter("price"));
//
//			con.setAutoCommit(false);
//            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
//
//            
//            int defaultIsolationLevel = con.getTransactionIsolation();
//            String isolationLevelName;
//            switch (defaultIsolationLevel) {
//                case Connection.TRANSACTION_READ_UNCOMMITTED:
//                    isolationLevelName = "READ UNCOMMITTED";
//                    break;
//                case Connection.TRANSACTION_READ_COMMITTED:
//                    isolationLevelName = "READ COMMITTED";
//                    break;
//                case Connection.TRANSACTION_REPEATABLE_READ:
//                    isolationLevelName = "REPEATABLE READ";
//                    break;
//                case Connection.TRANSACTION_SERIALIZABLE:
//                    isolationLevelName = "SERIALIZABLE";
//                    break;
//                default:
//                    isolationLevelName = "UNKNOWN";
//            }
//            System.out.println("Default Transaction Isolation Level: " + isolationLevelName);
//            
//            
//			PreparedStatement st=con.prepareStatement(
//				"insert into product(name, price) values(?, ?)");
//			st.setString(1, name);
//			st.setInt(2, price);
//			st.executeUpdate();
//
//			st=con.prepareStatement(
//				"select * from product where name=?");
//			st.setString(1, name);
//			ResultSet rs=st.executeQuery();
//			int line=0;
//			while (rs.next()) {
//				line++;
//			}
//
//            // トランザクション1を一定時間待機
////            System.out.println("トランザクション1が待機しています...");
////            Thread.sleep(10000);  // 10秒間待機
////            System.out.println("トランザクション1が待機終了しました。");
//            
//			if (line==1) {
//				con.commit();
//				out.println("商品を登録しました。");
//			} else {
//				con.rollback();
//				out.println("商品は既に登録されています。");
//			}
//
//			con.setAutoCommit(true);
//
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace(out);
//		}
//		Page.footer(out);
//	}
//}

