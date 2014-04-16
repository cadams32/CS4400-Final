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

	/*
	 * Wanted to return the type of user as a string.
	 */
	public static String login(String username, String password) {
		if(validateLogin(username, password)) {
			if(searchPatientForUser(username)) {
				return "Patient";
			}
			if(searchDoctorForUser(username)) {
				return "Doctor";
			}
		}
		return "Invalid";
	}
	
	/*
	 * Checks if the username and password combination exists in the DB
	 */
	private static boolean validateLogin(String username, String password) {
		boolean result = false;
		String query = "SELECT Username, Password FROM User WHERE User.Username = ? AND User.Password = ?";
		try {
			//Create the statement
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			//Execute the statement
			ResultSet resultSet = (ResultSet) statement.executeQuery();
			String dbU = "";
			String dbP = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("Username");
				dbP = resultSet.getString("Password");
			}
			if(dbU != null && dbP != null && username.equals(dbU) && password.equals(dbP)) {
				result = true;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		} 
		return result;
	}
	
	/*
	 * Checks if the username exists in the Doctor table
	 */
	private static boolean searchDoctorForUser(String username) {
		String query = "SELECT Username FROM Doctor WHERE Doctor.Username = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet resultSet = (ResultSet) statement.executeQuery();
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("Username");
			}
			if(dbU != null && username.equals(dbU)) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	
	/*
	 * Checks if the username exists in the Patient table
	 */
	private static boolean searchPatientForUser(String username) {
		String query = "SELECT Username FROM Patient WHERE Patient.Username = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet resultSet = (ResultSet) statement.executeQuery();
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("Username");
			}
			statement.close();
			if(dbU != null && username.equals(dbU)) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	

	//----------------------------------------------------------------------------------------------------------------
	
	/*
	 * Returns true if the username exists in the DB
	 */
	private static boolean doesUsernameExist(String username) {
		String query = "SELECT Username FROM User WHERE User.Username = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet resultSet = (ResultSet) statement.executeQuery();
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
			
		}
		return false;
	}
	
	/*
	 * Inserts a new User into the DB
	 */
	public static void addUser(String username, String password) {
		if(!doesUsernameExist(username)) {
			try {
				String query = "INSERT INTO User (Username, Password) VALUES(?, ?)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, username);
				statement.setString(2, password);
			} catch (Exception e) {
				
			}
		}
	}
	
	/*
	 * Inserts a new patient into the DB
	 */
	public static void addNewPatient(String username, String name, String dob, String gender, String address, String workPhone, String homePhone, String emerContactName, String emerContactPhone, String weight, String height, String annualIncome, String cardNumber) {
		
		if(!doesUsernameExist(username)) {
			try {
				String query = "INSERT INTO Patient (Paitent_Username, Name, DOB, Gender, Address, Work_Phone, Home_Phone, Emer_Contact_Name, Emer_Contact_Phone, Weight, Height, Annual_Income, Card_Number) " +
						"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, username);
				statement.setString(2, name);
				statement.setString(3, dob);
				statement.setString(4, gender);
				statement.setString(5, address);
				statement.setString(6, workPhone);
				statement.setString(7, homePhone);
				statement.setString(8, emerContactName);
				statement.setString(9, emerContactPhone);
				statement.setString(10, weight);
				statement.setString(11, height);
				statement.setString(12, annualIncome);
				statement.setString(13, cardNumber);
				statement.executeUpdate();
				statement.close();
			} catch (Exception e) {
				
			}
		}
	}
	
	/*
	 * Inserts New Doctor into the DB
	 */
	public static void addNewDoctor(String username, String licenseNo, String fName, String lName, String dob, String workPhone, String homeAddress, String specialty, String roomNo) {
		if(!doesUsernameExist(username)) {
			try {
				String query = "INSERT INTO Doctor (Doctor_Username, LicenseNo, FName, LName, DOB, Work_Phone, Home_Address, Specialty, Room_No)" +
							"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, username);
				statement.setString(2, licenseNo);
				statement.setString(3, fName);
				statement.setString(4, lName);
				statement.setString(5, dob);
				statement.setString(6, workPhone);
				statement.setString(7, homeAddress);
				statement.setString(8, specialty);
				statement.setString(9, roomNo);
			} catch (Exception e) {
				
			}
		}
	}

	
}

