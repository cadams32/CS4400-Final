package Backend;
import java.sql.*;


public class dataBaseConnection {
	private static final String connection = "jdbc:mysql://academic-mysql.cc.gatech.edu/phpmyadmin/cs4400_Group_37";
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String username = "cs4400_Group_37";
	private static final String password = "Vs2GEguW";
	
	public Connection createConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(driverName);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(connection, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(conn != null) {
			return conn;
			//Success!!!
		}
		
		return null;
	}
	
	public void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
