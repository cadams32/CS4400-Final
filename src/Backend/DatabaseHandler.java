package Backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Creates queries for manipulating the DB:
 * 
 * LOGIN
 * 		- login - String - the type of user being logged in "Patient", "Doctor", "Invalid"
 *			- validateLogin - boolean - searches the User table for username and password combination
 *			- searchDoctorForUser - boolean - searches the Doctor table for specific user
 *			- searchPatientForUser - boolean - searches the Patient table for specific user
 *		
 *
 * NEW USER
 * - doesUsernameExist - boolean - returns true if the username exists in the User table
 *		- addNewUser - void - inserts new User into User table with given params
 *		- addNewPatient - void - inserts new Patient into Patient table with given params
 *			-addNewPatientAllergy - void - inserts new Patient_Allergy into Patient_Allergy table
 *		- addNewDoctor - void - inserts new Doctor into Doctor table with given params
 *			-addNewDoctorAvailable - void inserts new DoctorAvailable into Doctor_Available table
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
	 * Login
	 * @param username
	 * @param password
	 * @return "Patient", "Doctor", "Admin", or "Invalid" based on the results
	 */
	public static String login(String username, String password) {
	
		if(validateLogin(username, password)) {
			if(searchPatientForUser(username)) {		
				return "Patient";
			}
			if(searchDoctorForUser(username)) {
				return "Doctor";
			}
			return "Admin";
		}
		return "Invalid";
	}
	
	/**
	 * Check if Username and Password both match in User table
	 * @param username
	 * @param password
	 * @return true if username and password are found in table matching
	 */
	private static boolean validateLogin(String username, String password) {
	
		boolean result = false;
		String query = "SELECT * FROM `User` WHERE `Username` = '" + username + "' AND `Password` =  '" + password + "'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			String dbP = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("Username");
				dbP = resultSet.getString("Password");
			}
			resultSet.close();
			statement.close();
			DBC.closeConnection(connection);
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
	 * @param username
	 * @return boolean if found
	 */
	private static boolean searchDoctorForUser(String username) {
		String query = "SELECT `DocUsername` FROM `Doctor` WHERE `DocUsername` = '" + username + "'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.prepareStatement(query);
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("DocUsername");
			}
			resultSet.close();
			statement.close();
			DBC.closeConnection(connection);
			if(dbU != null && username.equals(dbU)) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Search Patient for User
	 * @param username
	 * @return
	 */
	private static boolean searchPatientForUser(String username) {
		String query = "SELECT `PatientUsername` FROM `Patient` WHERE `PatientUsername` = '" + username + "'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.prepareStatement(query);
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("PatientUsername");
			}
			resultSet.close();
			statement.close();
			DBC.closeConnection(connection);
			if(dbU != null && username.equals(dbU)) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return false;
	}

	/**
	 * NEW USER
	 * 
	 * doesUsernameExist - Check if username is exists in User table
	 * addNewUser - Insert New User into User table
	 * addNewPatient - Insert New Patient into Patient table
	 * 		addNewPatientAllergy - Insert New Patient Allergy into Patient table
	 * addNewDoctor - Insert New Doctor into Doctor table
	 * 		addNewDoctorAvailable - Insert New DoctorAvailable into Patient table
	 */
	
	
	/**
	 * Check if Username exists.
	 * @param username
	 * @return
	 */
	private static boolean doesUsernameExist(String username) {
		String query = "SELECT  `Username` FROM  `User` WHERE  `Username` = '" + username + "'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.prepareStatement(query);
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("Username");
			}
			resultSet.close();
			statement.close();
			DBC.closeConnection(connection);
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
	 * Insert New User
	 * @param username
	 * @param password
	 */
	public static void addNewUser(String username, String password) {
		if(!doesUsernameExist(username)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`User` (`Username` ,`Password`) VALUES ('"+username+"',  '"+password+"')";
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
		DBC.closeConnection(connection);
	}
	
	/**
	 * Insert New Patient
	 * @param username
	 * @param password
	 */
	public static void addNewPatient(String username, String password) {
		if(!doesUsernameExist(username)) {
			String query = "";
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
	}
	
	/**
	 * Insert New Doctor
	 * @param username
	 * @param password
	 */
	public static void addNewPatientAllergy(String username, String password) {
		if(!doesUsernameExist(username)) {
			String query = "";
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
	}
	
	/**
	 * Insert New Doctor
	 * @param username
	 * @param password
	 */
	public static void addNewDoctor(String username, String password) {
		if(!doesUsernameExist(username)) {
			String query = "";
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
	}
	
	/**
	 * Insert New Doctor
	 * @param username
	 * @param password
	 */
	public static void addNewDoctorAvailable(String username, String password) {
		if(!doesUsernameExist(username)) {
			String query = "";
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
	}
	
	
	
	
}