package Backend;
import java.sql.*;


public class DataBaseConnection {
	
	public Connection createConnection() {    
        Connection conn = null; 
        try { 
        	System.out.println("Driver");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Success");
            conn = DriverManager.getConnection("jdbc:mysql://130.207.114.235/cs4400_Group_37", "cs4400_Group_37", "Vs2GEguW"); 
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
