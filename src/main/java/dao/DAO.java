package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DAO {
	static DataSource ds;

	public Connection getConnection() throws Exception {
		if (ds==null) {
			InitialContext ic=new InitialContext();
			ds=(DataSource)ic.lookup("java:/comp/env/jdbc/book");
		}
		return ds.getConnection();
	}
}
