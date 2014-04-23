package Backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Creates queries for manipulating the DB:
 * 
 * Note:
 * 		this ` symbol is used when declaring a table name or column name
 *		this ' symbol is used when we are declaring values
 *
 * 	Example:  SELECT * `USER` WHERE `Username` = 'username';
 * 
 * I have no idea why it is like this, but it kept yelling at me over it.
 * 
 * Note: Note: A lot of these are not fully tested/functional until the GUI is completed.
 * 
 * LOGIN
 * 		- login - String - the type of user being logged in "Patient", "Doctor", "Invalid"
 *			- validateLogin - boolean - searches the User table for username and password combination
 *			- searchDoctorForUser - boolean - searches the Doctor table for specific user
 *			- searchPatientForUser - boolean - searches the Patient table for specific user
 *		
 *
 * INSERT INTO
 * - doesUsernameExist - boolean - returns true if the username exists in the User table
 *		- addNewUser - void - inserts new User into User table with given params
 *		- addNewPatient - void - inserts new Patient into Patient table with given params
 *			-addNewPatientAllergy - void - inserts new Patient_Allergy into Patient_Allergy table
 *		- addNewDoctor - void - inserts new Doctor into Doctor table with given params
 *			-addNewDoctorAvailable - void inserts new DoctorAvailable into Doctor_Available table
 * 		- addNewDoctorRating
 * 		- addNewPaymentInformation
 * 		- addNewSurgery
 * 		- addNewSurgeryPreOpMeds
 * 		- addNewVisit
 * 		- addNewVisitDiagnosis
 * 		- addNewPrescription
 * 		- addNewCommunicatesWith
 * 		- addNewAppointments
 * 		- addNewPerforms
 * 		- addNewSendMessageToDoc
 * 		- addNewSendMessageToPat
 * 
 * Other Methods (For Populating GUI)
 * 
 * 
 */
public class DatabaseHandler {
	
	private static Connection connection;
	private static DataBaseConnection DBC = new DataBaseConnection();
	
	public DatabaseHandler() {
		DataBaseConnection DBC = new DataBaseConnection();
	}
	
	/**
	 * Login
	 * @param username
	 * @param password
	 * @return "Patient", "Doctor", "Admin", or "Invalid" based on the results
	 */
	public String login(String username, String password) {
	
		if(validateLogin(username, password)) {
			if(doesPatientExist(username)) {
				System.out.println("Hi");
				return "Patient";
			} else if (doesDoctorExist(username)) {
				return "Doctor";
			} else {
				return "Admin";
			}
		}
		return "Invalid";
	}
	
	/**
	 * Check if Username and Password both match in User table
	 * @param username
	 * @param password
	 * @return true if username and password are found in table matching
	 */
	private boolean validateLogin(String username, String password) {
	
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
	 * Check if Doctor Exists
	 * @param username
	 * @return boolean if found
	 */
	private static boolean doesDoctorExist(String username) {
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
	 * Check if Patient Exists
	 * @param username
	 * @return
	 */
	private static boolean doesPatientExist(String username) {
		String query = "SELECT `PatientUsername` FROM `Patient` WHERE `PatientUsername` = '" + username + "'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.prepareStatement(query);
			ResultSet resultSet = (ResultSet) statement.executeQuery(query);
			String dbU = "";
			while(resultSet.next()) {
				dbU = resultSet.getString("PatientUsername");
			}
			System.out.println(dbU);
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
	 * Check if User exists.
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
	public static boolean addNewUser(String username, String password) {
		if(!doesUsernameExist(username)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`User` (`Username` ,`Password`) VALUES ('"+username+"',  '"+password+"')";
			try {
				System.out.println("Swag");
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
				System.out.println("Swag2");
				return true;
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
		System.out.println("Not Swag");
		return false;
	}
	
	/**
	 * Insert New Patient
	 * @param username
	 * @param password
	 * @param name
	 * @param DOB
	 * @param gender
	 * @param address
	 * @param workPhone
	 * @param homePhone
	 * @param eContactName
	 * @param eContactPhone
	 * @param weight
	 * @param height
	 * @param annualIncome
	 */
	public static boolean addNewPatient(String username, String password, String name, String DOB, String gender, String address, String workPhone, String homePhone, String eContactName, String eContactPhone, int weight, int height, String annualIncome) {
		addNewUser(username, password);	
		if(!doesPatientExist(username)) {	
			String query = "INSERT INTO  `cs4400_Group_37`.`Patient` (`PatientUsername` ,`Name` ,`DOB` ,`Gender` ,`Address` ,`WorkPhone` ,`HomePhone` ,`EContactName` ,`EContactPhone` ,`Weight` ,`Height` ,`AnnualIncome` ,`CardNo`) VALUES ('"+username+"',  '"+name+"',  '"+DOB+"',  '"+gender+"',  '"+address+"',  '"+workPhone+"',  '"+homePhone+"',  '"+eContactName+"',  '"+eContactPhone+"',  '"+weight+"',  '"+height+"',  '"+annualIncome+"', NULL);";
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
				return true;
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
		return false;
	}

	/**
	 * Insert New Patient_Allergies
	 * @param patientUsername
	 * @param allergy
	 */
	public static void addNewPatientAllergy(String patientUsername, String allergy) {
		if(doesPatientExist(patientUsername)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Patient_Allergies` (`PatientUsername` ,`Allergy`) VALUES ('"+patientUsername+"',  '"+allergy+"')";
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
	 * @param licenseNo
	 * @param fName
	 * @param lName
	 * @param DOB
	 * @param homeAddress
	 * @param specialty
	 * @param roomNo
	 */
	public static boolean addNewDoctor(String username, String password, String licenseNo, String fName, String lName, String DOB, String workPhone, String homeAddress, String specialty, int roomNo) {
		addNewUser(username, password);	
		if(!doesDoctorExist(username)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Doctor` (`DocUsername` ,`LicenseNo`, `FName`, `LName`, `DOB`, `WorkPhone`, `HomeAddress`, `Specialty`, `RoomNo`) VALUES ('"+username+"',  '"+licenseNo+"', '"+fName+"', '"+lName+"', '"+DOB+"', '"+workPhone+"','"+homeAddress+"', '"+specialty+"', '"+roomNo+"')";;
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
				System.out.println("Doc");
				return true;
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
		return false;
	}
	
	/**
	 * Insert New Doctor_Available
	 * @param username
	 * @param to
	 * @param from
	 * @param day
	 */
	public static void addNewDoctorAvailable(String username, String to, String from, String day) {
		if(doesUsernameExist(username)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Doctor_Available` (`DocUsername`, `To`, `From`, `Day`) VALUES ('"+username+"', '"+to+"', '"+from+"', '"+day+"')";
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
				System.out.println("avail");
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			}
		}
	}
	
	/**
	 * Insert New Doctor_Rating
	 * @param docUsername
	 * @param patUsername
	 * @param rating
	 */
	public static void addNewDoctorRating(String docUsername, String patUsername, int rating) {
		if(doesDoctorExist(docUsername) && doesPatientExist(patUsername)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Doctor_Rating` (`DocUsername` ,`PatientUsername` ,`Rating`) VALUES ('"+docUsername+"',  '"+patUsername+"',  '"+rating+"')";
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
	
	//TODO: Copy Pasta
	
	public static void addNewPaymentInformation(String cardNumber, String cardHolderName, String CVV, String dateOfExpiry, String type) { 
		String query = "INSERT INTO `cs4400_Group_37`.`PaymentInformation` (`CardNo`, `CardHolderName`, `CVV`, `Date ";
		
	}
	
	public static void addNewSurgery(String CPTCode, String surgeryType, int costOfSurgery) { }
	
	public static void addNewSurgeryPreOpMeds(String CPTCode, String preOpMedication){ }
	
	//Note: VisitID should be an auto-incrementing unsigned integer AKA: automatic
	public static void addNewVisit(int visitId, String docUsername, String patUsername, String dateOfVisit, int diastolic, int systolic, int billingAmount) { }
	
	public static void addNewVisitDiagnosis(int visitID, String diagnosis) { }
	
	//Note: Ordered = Yes or No
	public static void addNewPrescription(int visitID, String medicineName, int dosage, int duration, String notes, String ordered) { }
	
	//Note: Status = Read or Unread
	public static void addNewCommunicatesWith(String docSender, String docReceiver, String dateTime, String content, String status) { }
	
	public static void addNewAppointments(String docUsername, String patientUsername, String date, String time) { }
	
	public static void addNewPerforms(String docUsername, String patientUsername, String CPTCode, String surgeryStartTime, String surgeryEndTime, String anesthesiaStart, String complications, int noOfAssistants) { }
	
	//Note: Status = Read or Unread
	public static void addNewSendMessageToDoc(String patUsername, String docUsername, String dateTime, String content, String status) { }
	
	//Note: Status = Read or Unread
	public static void addNewSendMessageToPatient(String docUsername, String patUsername, String dateTime, String content, String status) { }
	
	//Creating Appointment Screen
	/**
	 * Gets the First Name, Last Name, RoomNo, and Username of all doctors of a specific Specialty
	 * @param specialty
	 * @return List with Doctors of a specific specialty
	 */
	public static ArrayList<Doctor> getSpecialtyDoctors(String specialty){ 
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		String query = "SELECT * FROM `Doctor` WHERE `Specialty`='"+specialty+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			while(rs.next()) {
				String username = rs.getString("DocUsername");
				String fName = rs.getString("FName");
				String lName = rs.getString("LName");
				int roomNo = rs.getInt("RoomNo");
				list.add(new Doctor(username, fName, lName, roomNo));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return list;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return null;
	}
	//Returns average Doctor rating
	public static int getDoctorRating(String docUsername) { return -1; }
	//Returns list of availability
	public static ArrayList<Availability> getDoctorAvailability(String docUsername) { return null; }
	
	//Creating Order Prescription
	//get the Visits of a Patient
	public static ArrayList<Visit> getPatientVisits(String username) { return null; }
	//get Prescriptions for a Visit (not Ordered)
	public static ArrayList<Prescription> getVisitPrescriptions(int visitID) { return null; }
	//Get a Doctor
	public static Doctor getDoctor(String username) { return null; }
	//Change Prescription Ordered from No to Yes
	public static void updatePrescription() { }
	
	//Creating View Visit History
	//Reuse getPatientVisits()
	//get Visit_Diagnosis
	public static String getVisitDiagnosis(int visitID) { return null; }
	//Reuse getPrescriptionsForVisit()
	//Reuse Get a Doctor
	
	//Creating Rate A Doctor
	//Insert Into Doctor...
	
	//Creating Edit Profile for Doctor and Patient
	public static void updatePatientProfile() { }
	public static void updateDoctorProfile() { }
	
	//Creating AppointmentCalendar
	//get all appointments of a doctor
	public static ArrayList<Appointment> getAppointmentsForDoctor(String docUsername) { return null; }
	//get a specific patient
	public static Patient getPatient(String patUsername) { return null; }
	
	//Patient Visit History
	//get a Patient based on name and homePhone? (May need to return a list)
	public static Patient getPatient(String name, String homePhone) { return null; }
	//Reuse getPatientVisits()
	//Reuse getVisitDiagnosis()
	//Reuse getVisitPrescriptions()
	
	//Record a visit
	//Insert visit
	//Insert visit_diagnosis
	//Insert visit_prescription
	
	//Surgery Record
	//Reuse getPatient(name, homePhone)
	//Insert Surgery
	//Insert SurgeryPreOpMed
	//Insert Performs
	
	//Messages
	//TODO
	
	//Reports
	//TODO
	
}