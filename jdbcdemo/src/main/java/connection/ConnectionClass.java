package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.sql.ArrayDescriptor;

public class ConnectionClass {

	public static Connection getEDBConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "dev";
		// Class.forName("com.edb.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	/*
	 * public static ArrayDescriptor getDescriptor(String recordType, Connection
	 * connection) throws SQLException {
	 * 
	 * return (ArrayDescriptor) (WSCallHelper.jdbcPass(ArrayDescriptor.class,
	 * "createDescriptor", new Object[] { recordType, connection }, new Class[] {
	 * java.lang.String.class, Connection.class }, new int[] { WSCallHelper.IGNORE,
	 * WSCallHelper.CONNECTION }));
	 * 
	 * }
	 */
}
