package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcLink {
			public Connection getConn()  {
				Connection conn = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:orcl";
					String user = "scott";
					String password ="tiger";
		            conn=DriverManager.getConnection(url, user, password);			
								} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				return conn;
			}
}

