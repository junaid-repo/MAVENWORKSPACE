package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	
	public static Connection getEDBConnection() throws
	  ClassNotFoundException, SQLException {
	  String url = "jdbc:oracle:thin:@localhost:1521:XE";
	  String user = "dev";
	  String password = "dev";
	 // Class.forName("com.edb.Driver");
	  Connection conn = DriverManager.getConnection(url, user, password);
	  return conn;
	}

}
