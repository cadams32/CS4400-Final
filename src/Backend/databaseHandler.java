package Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseHandler {
	
	private static Connection connection;
	
	public databaseHandler() {
		dataBaseConnection DBC = new dataBaseConnection();
		connection = DBC.createConnection();
	}

	private static boolean login(String username, String password) throws SQLException {
		boolean result = false;
		Statement stmt = null;
		String query = "SELECT User FROM User WHERE User.Username=username AND User.Password=password";
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String dbU = "";
			String dbP = "";
			while(rs.next()) {
				dbU = rs.getString("Username");
				dbP = rs.getString("Password");
			}
			if(dbU != null && dbP != null && username.equals(dbU) && password.equals(dbP)) {
				result = true;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return result;
	}
	
	private static boolean searchDoctorForUser(String username) {
		return false;
	}
	
	private static boolean searchPatientForUser(String username) {
		return false;
	}
	

}
