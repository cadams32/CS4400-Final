package Backend;
import java.sql.*;


public class dataBaseConnection {
	private static final String connection = "";
	private static final String driverName = "";
	private static final String username = "cs4400_Group_37";
	private static final String password = "";

	public dataBaseConnection() {
	}
	
	public Connection createConnection() {
		Connection conn = null;
		try {
			if (!conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			
		}
		
		return null;
	}
	
	public void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			
		}
	}
	
}
