package Backend;
import java.sql.*;


public class DataBaseConnection {
	private static final String connection = "jdbc:mysql://academic-mysql.cc.gatech.edu/phpmyadmin/cs4400_Group_37";
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String username = "cs4400_Group_37";
	private static final String password = "Vs2GEguW";
	
	public Connection createConnection() {    
        Connection conn = null; 
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/phpmyadmin/cs4400_Group_37", "cs4400_Group_37", "Vs2GEguW"); 
            if(!conn.isClosed()) {
                System.out.println("Successfully connected to " + 
                "MySQL server using TCP/IP..."); 
                return conn;
            }
        } catch(Exception e) { 
            System.err.println("Exception: " + e.getMessage()); 
        }
        System.out.println("Not Swag");
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
