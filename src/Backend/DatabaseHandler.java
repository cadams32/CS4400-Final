package Backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Creates queries for manipulating the DB:
 * 
 * 		- login - String - the type of user being logged in "Patient", "Doctor", "Invalid"
 *			- validateLogin - boolean - searches the User table for username and password combination
 *			- searchDoctorForUser - boolean - searches the Doctor table for specific user
 *			- searchPatientForUser - boolean - searches the Patient table for specific user
 *		- doesUsernameExist - boolean - returns true if the username exists in the User table
 *		- addNewUser - void - inserts new User into User table with given params
 *		- addNewPatient - void - inserts new Patient into Patient table with given params
 *		- addNewDoctor - void - inserts new Doctor into Doctor table with given params
 * 
 * 
 */
public class DatabaseHandler {
	
	private static Connection connection;
	private static DataBaseConnection DBC;
	
	public DatabaseHandler() {
		DataBaseConnection DBC = new DataBaseConnection();
	}
	
	/**
	 * Wanted to return the type of user as a string.
	 */
	public static String login(String username, String password) {
		connection = DBC.createConnection();
		if(validateLogin(username, password)) {
			DBC.closeConnection(connection);
			if(searchPatientForUser(username)) {
				DBC.closeConnection(connection);
				return "Patient";
			}
			if(searchDoctorForUser(username)) {
				DBC.closeConnection(connection);
				return "Doctor";
			}
			DBC.closeConnection(connection);
			return "Admin";
		}
		DBC.closeConnection(connection);
		return "Invalid";
	}
	
	/**
	 * 
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private static boolean validateLogin(String username, String password) {
		boolean result = false;
		
		System.out.println(username + " " + password);
		
		String query = "SELECT * FROM `User` WHERE `Username` = '" + username + "' AND `Password` =  '" + password + "'";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			String dbP = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("Username");
				dbP = resultSet.getString("Password");
			}
			if(dbU != null && dbP != null && username.equals(dbU) && password.equals(dbP)) {
				result = true;
			}
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} 
		return result;
	}
	
	/**
	 * Search for a specific Doctor based on user
	 * 
	 * @param username
	 * @return boolean if found
	 */
	private static boolean searchDoctorForUser(String username) {
		String query = "SELECT `DocUsername` FROM `Doctor` WHERE `DocUsername` = '" + username + "'";
		try {
			Statement statement = connection.prepareStatement(query);
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("DocUsername");
			}
			statement.close();
			if(dbU != null && username.equals(dbU)) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * search Patient for User
	 * 
	 * @param username
	 * @return
	 */
	private static boolean searchPatientForUser(String username) {
		String query = "SELECT `PatientUsername` FROM `Patient` WHERE `PatientUsername` = '" + username + "'";
		try {
			Statement statement = connection.prepareStatement(query);
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("PatientUsername");
			}
			statement.close();
			if(dbU != null && username.equals(dbU)) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return false;
	}
	
	//---------------------------------------------------------------------------------
	
	/**
	 * Check if username exists.
	 * 
	 * @param username
	 * @return
	 */
	private static boolean doesUsernameExist(String username) {
		String query = "SELECT  `Username` FROM  `User` WHERE  `Username` = '" + username + "'";
		try {
			Statement statement = connection.prepareStatement(query);
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("Username");
			}
			statement.close();
			if(dbU != null && username.equals(dbU)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Insert into User
	 * 
	 * @param username
	 * @param password
	 */
	public static void addUser(String username, String password) {
		connection = DBC.createConnection();
		if(!doesUsernameExist(username)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`User` (`Username` ,`Password`) VALUES ('"+username+"',  '"+password+"')";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
		DBC.closeConnection(connection);
	}
}