package Backend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
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
	public static boolean doesDoctorExist(String username) {
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
	public static boolean doesPatientExist(String username) {
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
			
			if(dbU != null && username.equals(dbU)) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
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
	public static boolean doesUsernameExist(String username) {
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
		} finally {
			DBC.closeConnection(connection);
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
			} finally {
				DBC.closeConnection(connection);
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
			} finally {
				DBC.closeConnection(connection);
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
			} finally {
				DBC.closeConnection(connection);
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
			} finally {
				DBC.closeConnection(connection);
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
			} finally {
				DBC.closeConnection(connection);
			}
		}
	}
	
	/**
	 * Insert New Doctor_Rating
	 * @param docUsername
	 * @param patUsername
	 * @param rating
	 */
	public boolean addNewDoctorRating(String docUsername, String patUsername, int rating) {
		if(doesDoctorExist(docUsername) && doesPatientExist(patUsername)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Doctor_Rating` (`DocUsername` ,`PatientUsername` ,`Rating`) VALUES ('"+docUsername+"',  '"+patUsername+"',  '"+rating+"')";
			try {
				connection = DBC.createConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				statement.close();
				DBC.closeConnection(connection);
				System.out.println("Hi");
				return true;
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
			} finally {
				DBC.closeConnection(connection);
			}
		}
		return false;
	}
	
	/**
	 * Add New Payment Information
	 * @param cardNumber
	 * @param cardHolderName
	 * @param CVV
	 * @param dateOfExpiry
	 * @param type
	 * @return
	 */
	public static boolean addNewPaymentInformation(String cardNumber, String cardHolderName, String CVV, String dateOfExpiry, String type) { 
		String query = "INSERT INTO `cs4400_Group_37`.`Payment_Information` (`CardNo`, `CardHolderName`, `CVV`, `DateOfExpiry`, `Type`) VALUES ('" +
				cardNumber + "', '" + cardHolderName + "', '" + CVV + "', '" + dateOfExpiry + "', '" + type + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New Surgery
	 * @param CPTCode
	 * @param surgeryType
	 * @param costOfSurgery
	 * @return
	 */
	public boolean addNewSurgery(String CPTCode, String surgeryType, int costOfSurgery) {
		String query = "INSERT INTO `cs4400_Group_37`.`Surgery` (`CPTCode`, `SurgeryType`, `CostOfSurgery`) VALUES ('" +
				CPTCode + "', '" + surgeryType + "', '" + costOfSurgery + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New SurgeryPreOpMeds
	 * @param CPTCode
	 * @param preOpMedication
	 * @return
	 */
	public static boolean addNewSurgeryPreOpMeds(String CPTCode, String preOpMedication){
		String query = "INSERT INTO `cs4400_Group_37`.`SurgeryPreOpMeds` (`CPTCode`, `PreOpMedication`) VALUES ('" +
				 CPTCode + "', '" + preOpMedication + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New Visit
	 * @param docUsername
	 * @param patUsername
	 * @param dateOfVisit
	 * @param diastolic
	 * @param systolic
	 * @param billingAmount
	 * @return
	 */
	public static boolean addNewVisit(String docUsername, String patUsername, String dateOfVisit, int diastolic, int systolic, int billingAmount) {
		String query = "INSERT INTO `cs4400_Group_37`.`Visit` (`DocUsername`, `PatientUsername`, `DateOfVisit`, `Diastolic`, `Systolic`, `BillingAmount`) VALUES ('" + docUsername + "', '" + patUsername + "', '" + dateOfVisit + "', '" + diastolic + "', '" + systolic + "', '" + billingAmount + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New Visit Diagnosis
	 * @param diagnosis
	 * @return
	 */
	public static boolean addNewVisitDiagnosis(String patientUsername, String docUsername, String dateOfVisit, String diagnosis) {
		String query = "INSERT INTO `cs4400_Group_37`.`Visit_Diagnosis` (`patientUsername`, `docUsername`, `dateOfVisit`, `Diagnosis`) VALUES ('" +
				patientUsername + "', '" + "', '" + docUsername + "', '" + dateOfVisit + "', '" + diagnosis + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New Prescription
	 * @param visitID
	 * @param medicineName
	 * @param dosage
	 * @param duration
	 * @param notes
	 * @param ordered
	 * @return
	 */
	public static boolean addNewPrescription(String patientUsername, String docUsername, String dateOfVisit, String medicineName, int dosage, int duration, String notes, String ordered) {
		String query = "INSERT INTO `cs4400_Group_37`.`Prescription` (`DateOfVisit`, `PatUsername`, `DocUsername`, `MedicineName`, `Dosage`, `Duration`, `Notes`, `Ordered(Yes/No)`) VALUES ('" +
				dateOfVisit + "', '" + patientUsername + "', '" + docUsername + "', '" + "', '" + medicineName + "', '" + dosage + "', '" + duration + "', '" + notes + "', '" + ordered + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New ComunicatesWith
	 * @param docSender
	 * @param docReceiver
	 * @param dateTime
	 * @param content
	 * @param status
	 * @return
	 */
	public static boolean addNewCommunicatesWith(String docSender, String docReceiver, String dateTime, String content, String status) {
		String query = "INSERT INTO `cs4400_Group_37`.`CommunicatesWith` (`Doc_Sender`, `Doc_Receiver`, `DateTime`, `Content`, `Status`) VALUES ('" +
				docSender + "', '" + docReceiver + "', '" + dateTime + "', '" + content + "', '" + status + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New Appointments
	 * @param docUsername
	 * @param patientUsername
	 * @param date
	 * @param time
	 * @return
	 */
	public static boolean addNewAppointments(String docUsername, String patientUsername, String date, String time) {
		String query = "INSERT INTO `cs4400_Group_37`.`Appointment` (`DocUsername`, `PatientUsername`, `Date`, `Time`) VALUES ('" +
				docUsername + "', '" + patientUsername + "', '" + date + "', '" + time + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New Performs
	 * @param docUsername
	 * @param patientUsername
	 * @param CPTCode
	 * @param surgeryStartTime
	 * @param surgeryEndTime
	 * @param anesthesiaStart
	 * @param complications
	 * @param noOfAssistants
	 * @return
	 */
	public static boolean addNewPerforms(String docUsername, String patientUsername, String CPTCode, String surgeryStartTime, String surgeryEndTime, String anesthesiaStart, String complications, int noOfAssistants) {
		String query = "INSERT INTO `cs4400_Group_37`.`Performs` (`DocUsername`, `PatientUsername`, `CPTCode`, `SurgeryStartTime`, `SurgeryEndTime`, `AnethesiaStartTIme`, `Complications`, `NoOfAssistants`) VALUES ('" +
				docUsername + "', '" + patientUsername + "', '" + CPTCode + "', '" + surgeryStartTime + "', '" + surgeryEndTime + "', '" + anesthesiaStart + "', '" + complications + "', '" + noOfAssistants + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New Send Message to Doc
	 * @param patUsername
	 * @param docUsername
	 * @param dateTime
	 * @param content
	 * @param status
	 * @return
	 */
	public static boolean addNewSendMessageToDoc(String patUsername, String docUsername, String dateTime, String content, String status) {
		String query = "INSERT INTO `cs4400_Group_37`.`SendsMessageToDoc` (`PatientUsername`, `DocUsername`, `DateTime`, `Content`, `Status`) VALUES ('" +
				patUsername + "', '" + docUsername + "', '" + dateTime + "', '" + content + "', '" + status + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Add New Sedn Message to Patient
	 * @param docUsername
	 * @param patUsername
	 * @param dateTime
	 * @param content
	 * @param status
	 * @return
	 */
	public static boolean addNewSendMessageToPatient(String docUsername, String patUsername, String dateTime, String content, String status) {
		String query = "INSERT INTO `cs4400_Group_37`.`SendsMessageToPatient` (`DocUsername`, `PatientUsername`, `DateTime`, `Content`, `Status`) VALUES ('" +
				docUsername + "', '" + patUsername + "', '" + dateTime + "', '" + content + "', '" + status + "')";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * Other
	 */
	
	/**
	 * Creating Appointment Screen
	 */
	
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
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	/**
	 * Get the Average Doctor Rating of a particular doctor (using their username)
	 * @param docUsername
	 * @return
	 */
	public static String getDoctorRating(String docUsername) { 
		String query = "SELECT AVG(`Rating`) as avg FROM `Doctor_Rating` WHERE `DocUsername`='"+docUsername+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String i="";
			while(rs.next()){
				i = rs.getString("avg");
			}
			
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return i;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	} 
	
	/**
	 * Returns a list of all of the Availabilities of a specific doctor (Using Username of the doctor)
	 * @param docUsername
	 * @return
	 */
	public static ArrayList<Availability> getDoctorAvailability(String docUsername) {
		ArrayList<Availability> list = new ArrayList<Availability>();
		String query = "SELECT * FROM `Doctor_Available` WHERE `DocUsername`='"+docUsername+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			while(rs.next()) {
				String to = rs.getString("To");
				String from = rs.getString("From");
				String day = rs.getString("Day");
				list.add(new Availability(to, from, day));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return list;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	/**
	 * Creating Order Prescription
	 */
	
	/**
	 * Get all of the Visits of a Particular Patient (Using PatientUsername)
	 * @param username
	 * @return
	 */
	public static ArrayList<Visit> getPatientVisits(String username) {
		ArrayList<Visit> list = new ArrayList<Visit>();
		String query = "SELECT * FROM `Visit` WHERE `PatientUsername`='"+username+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			while(rs.next()) {
				String docUsername = rs.getString("DocUsername");
				String dateOfVisit = rs.getString("DateOfVisit");
				int diastolic = rs.getInt("Diastolic");
				int systolic = rs.getInt("Systolic");
				int billingAmount = rs.getInt("BillingAmount");
				
				list.add(new Visit(docUsername, null, dateOfVisit, diastolic, systolic, billingAmount));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return list;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	/**
	 * Get all of the Prescriptions of a particular visit (Using VisitID)
	 * @param visitID
	 * @return
	 */
	public ArrayList<Prescription> getVisitPrescriptions(String patientUsername, String docUsername, String dateOfVisit) {
		ArrayList<Prescription> list = new ArrayList<Prescription>();
		String query = "SELECT * FROM `Prescription` WHERE `PatUsername`='"+patientUsername+"' AND  `DocUsername`='" +docUsername+"'AND `DateOfVisit`= '" + dateOfVisit + "'"; 
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			while(rs.next()) {
				String medicineName = rs.getString("MedicineName");
				int dosage = rs.getInt("Dosage");
				int duration = rs.getInt("Duration");
				String notes = rs.getString("Notes");
				String ordered = rs.getString("Ordered(Yes/No)");
				
				list.add(new Prescription(patientUsername, docUsername, dateOfVisit, medicineName, dosage, duration, notes, ordered));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return list;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public Visit getVisit(String patUsername, String docUsername, String date) {
		String query = "SELECT * FROM `Visit` WHERE `PatientUsername`='"+patUsername+"' AND `DocUsername`='"+docUsername+"' AND `DateOfVisit`='"+date+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String docUsername2 = "";
			String dateOfVisit = "";
			int diastolic = -1;
			int systolic = -1;
			int billingAmount = -1;
			while(rs.next()) {
				dateOfVisit = rs.getString("DateOfVisit");
				diastolic = rs.getInt("Diastolic");
				systolic = rs.getInt("Systolic");
				billingAmount = rs.getInt("BillingAmount");
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return new Visit(docUsername, patUsername, dateOfVisit, diastolic, systolic, billingAmount);
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}

	/**
	 * Get everything from Doctor Using Doctor Username
	 * Actually just returning fName, lName and roomNo
	 * @param username
	 * @return
	 */
	public Doctor getDoctor(String username) { 
		String query = "SELECT * FROM `Doctor` WHERE `DocUsername`='"+username+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String fName = ""; 
			String lName = "";
			String docUsername = "";
			int roomNo = -1;
			while(rs.next()) {
				docUsername = rs.getString("DocUsername");
				fName = rs.getString("FName");
				lName = rs.getString("LName");
				roomNo = rs.getInt("RoomNo");
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return new Doctor(docUsername, fName, lName, roomNo);
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
		
	}
	
	//Change Prescription Ordered from No to Yes
	public static void updatePrescription() { }
	
	
	/**
	 * Creating View Visit History
	 */
	
	//Creating View Visit History
	//Reuse getPatientVisits() X
	
	/**
	 * Get all visits
	 * @param visitID
	 * @return
	 */
	public String getVisitDiagnosis(String patientUsername, String docUsername, String dateOfVisit) { 
		String query = "SELECT `Diagnosis` FROM `Visit_Diagnosis` WHERE `PatientUsername`='"+patientUsername+"' AND  `DocUsername`='" +docUsername+"'AND `DateOfVisit`= '" + dateOfVisit + "'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String diagnosis = "";
			while(rs.next()) {
				diagnosis = rs.getString("Diagnosis");
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return diagnosis;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	
	}

	//Reuse getPrescriptionsForVisit()
	//Reuse Get a Doctor
	

	/**
	 * Rate A Doctor
	 */
	
	/**
	 * Get Doctors returns all Doctors
	 * @return
	 */
	public ArrayList<Doctor> getDoctors() { 
		ArrayList<Doctor> docs = new ArrayList<Doctor>();
		String query = "SELECT `DocUsername`, `FName`, `LName` FROM `Doctor`";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String fName = ""; 
			String lName = "";
			String docUsername = "";
			while(rs.next()) {
				docUsername = rs.getString("DocUsername");
				fName = rs.getString("FName");
				lName = rs.getString("LName");
				System.out.println(fName + " " + lName);
				docs.add(new Doctor(docUsername, fName, lName));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return docs;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	//Creating AppointmentCalendar
	//get all appointments of a doctor
	public ArrayList<Appointment> getAppointmentsForDoctor(String username) { 
		ArrayList<Appointment> appts = new ArrayList<Appointment>();
		String query = "SELECT * FROM `Appointment` WHERE `DocUsername`='"+username+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String docUsername = ""; 
			String patUsername = "";
			Date date;
			Time time;
			while(rs.next()) {
				docUsername = rs.getString("DocUsername");
				patUsername = rs.getString("PatientUsername");
				date = rs.getDate("Date");
				time = rs.getTime("Time");
				appts.add(new Appointment(docUsername, patUsername, date, time));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return appts;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public ArrayList<Appointment> getAppointmentsForDoctorByDate(String username, Date date) {
		ArrayList<Appointment> appts = new ArrayList<Appointment>();
		String query = "SELECT * FROM `Appointment` WHERE `DocUsername`='"+username+"' AND `Date`='"+date+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String patUsername = "";
			Time time;
			while(rs.next()) {
				patUsername = rs.getString("PatientUsername");
				time = rs.getTime("Time");
				appts.add(new Appointment(username, patUsername, date, time));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return appts;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	/**
	 * Just returns the name at them moment modify it to return whatever you want
	 * @param username
	 * @return
	 */
	public static Patient getPatient(String username) { 
		String query = "SELECT `Name`, `AnnualIncome` FROM `Patient` WHERE `PatientUsername`='"+username+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String name = "";
			String ai = "";
			while(rs.next()) {
				name = rs.getString("Name");
				ai = rs.getString("AnnualIncome");
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return new Patient(username, name, ai, "Patient");
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public ArrayList<Patient> getPatients() {
		ArrayList<Patient> pats = new ArrayList<Patient>();
		String query = "SELECT * FROM `Patient`";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String name = "";
			String username = "";
			while(rs.next()) {
				username = rs.getString("PatientUsername");
				name = rs.getString("Name");
				System.out.println(username + " " + name);
				pats.add(new Patient(username, name));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return pats;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public ArrayList<String> getPatientsNames() {
		ArrayList<String> pats = new ArrayList<String>();
		String query = "SELECT `Name` FROM `Patient`";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String name = "";
			while(rs.next()) {
				name = rs.getString("Name");
				pats.add(name);
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return pats;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public static String getDoctorUsername(String fName, String lName) {
		String query = "SELECT `DocUsername` FROM `Doctor` WHERE `FnName`='"+fName+"', '"+lName+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String username = "";
			while(rs.next()) {
				username = rs.getString("Username");
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return username;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}

	public static ArrayList<Patient> getPatientFromName(String name) {
		ArrayList<Patient> pats = new ArrayList<Patient>();
		String query = "SELECT `PatientUsername`, `HomePhone`, `WorkPhone`, `AnnualIncome` FROM `Patient` WHERE `Name`='"+name+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String username = "";
			String homePhone = "";
			String workPhone = "";
			String annualIncome = "";
			while(rs.next()) {
				username = rs.getString("PatientUsername");
				homePhone = rs.getString("HomePhone");
				workPhone = rs.getString("WorkPhone");
				annualIncome = rs.getString("AnnualIncome");
				pats.add(new Patient(username, name, homePhone, workPhone, annualIncome, "Patient"));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return pats;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	
	//Patient Visit History
	//get a Patient based on name and homePhone? (May need to return a list)
	public static String getPatientUsername(String name, String homePhone) {
		String query = "SELECT `PatientUsername` FROM `Patient` WHERE `Name`='"+name+"' AND `HomePhone`='"+homePhone+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String username = "";
			while(rs.next()) {
				username = rs.getString("PatientUsername");
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return username;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;

	}
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
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public static ArrayList<Message> getCommunicatesWith(String username) {
		ArrayList<Message> msgs = new ArrayList<Message>();
		String query = "SELECT * FROM `CommunicatesWith` WHERE `Doc_Receiver`='"+username+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String sender = "";
			String date = "";
			String status = "";
			String message = "";
			while(rs.next()) {
				sender = rs.getString("Doc_Sender");
				date = rs.getString("DateTime");
				status = rs.getString("Status");
				message = rs.getString("Content");
				msgs.add(new Message(message, sender, username, date, status));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return msgs;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
		
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public static ArrayList<Message> getSendsMessageToPatient(String username) {
		ArrayList<Message> msgs = new ArrayList<Message>();
		String query = "SELECT * FROM `SendsMessageToPatient` WHERE `PatientUsername`='"+username+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String sender = "";
			String date = "";
			String status = "";
			String message = "";
			while(rs.next()) {
				sender = rs.getString("DocUsername");
				date = rs.getString("DateTime");
				status = rs.getString("Status");
				message = rs.getString("Content");
				msgs.add(new Message(message, sender, username, date, status));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return msgs;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public static ArrayList<Message> getSendsMessageToDoc(String username) {
		ArrayList<Message> msgs = new ArrayList<Message>();
		String query = "SELECT * FROM `SendsMessageToDoc` WHERE `DocUsername`='"+username+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String sender = "";
			String date = "";
			String status = "";
			String message = "";
			while(rs.next()) {
				sender = rs.getString("PatientUsername");
				date = rs.getString("DateTime");
				status = rs.getString("Status");
				message = rs.getString("Content");
				msgs.add(new Message(message, sender, username, date, status));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return msgs;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	//Reports
	//TODO
	//Creating Edit Profile for Doctor and Patient
	/**
	 * 
	 * @param patUsername
	 * @param patName
	 * @param dob
	 * @param gender
	 * @param address
	 * @param workPhone
	 * @param homePhone
	 * @param EContactName
	 * @param EContactPhone
	 * @param weight
	 * @param height
	 * @param annualInc
	 * @return
	 */
	public static boolean updatePatientProfile(String patUsername, String patName, String dob, String gender, String address,
			String workPhone, String homePhone, String EContactName, String EContactPhone, int weight, int height, String annualInc) {
		
		String query = "UPDATE `cs4400_Group_37`.`Patient` SET `Name` = '" + patName + "', `DOB` = '" + dob + "', `Gender` = '" + gender + 
			"', `Address` = '" + address + "', `WorkPhone` = '" + workPhone + "', `HomePhone` = '" + homePhone + 
			"', `EContactName` = '" + EContactName + "', `EContactPhone` = '" + EContactPhone +
			"', `Weight` = '" + weight + "', `Height` = '" + height + "', `AnnualIncome` = '" + annualInc +
			"' WHERE `PatientUsername` = '" + patUsername + "'";

		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	/**
	 * 
	 * @param docUsername
	 * @param licenseNo
	 * @param Fname
	 * @param Lname
	 * @param dob
	 * @param workPhone
	 * @param homeAddress
	 * @param specialty
	 * @param roomNo
	 * @return
	 */
	public static boolean updateDoctorProfile(String docUsername, String licenseNo, String Fname, String Lname ,String dob, 
			String workPhone, String homeAddress, String specialty, int roomNo) {
		
		String query = "UPDATE `cs4400_Group_37`.`Doctor` SET `LicenseNo` = '" + licenseNo + "', `Fname` = '" + Fname + 
			"', `Lname` = '" + Lname + "', `DOB` = '" + dob + "', `WorkPhone` = '" + workPhone + 
			"', `HomeAddress` = '" + homeAddress + "', `Specialty` = '" + specialty + "', `RoomNo` = '" + roomNo + 
			"' WHERE `DocUsername` = '" + docUsername + "'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
			DBC.closeConnection(connection);
			return true;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return false;
	}
	
	public static boolean updatePatientAllergies(String patUsername, String Allergy) {
		String query = "UPDATE `cs4400_Group_37`.`Patient_Allergies` SET `Allergy` = '" + Allergy + "' WHERE `PatientUsername` = '" + patUsername + "'";
		
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
		return false;
	}
	
	public static String getPatientPhoneNumber(String name) {
		String query = "SELECT `HomePhone` FROM `Patient` WHERE `Name`='"+name+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String phone = "";
			
			while(rs.next()) {
				phone = rs.getString("HomePhone");
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return phone;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public static ArrayList<String> getCPTCode(String username) {
		ArrayList<String> list = new ArrayList<String>();
		String query = "SELECT `CPTCode` FROM `Performs` WHERE `PatientUsername`='"+username+"' OR `DocUsername` = '"+username+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String cpt = "";
			while(rs.next()) {
				cpt = rs.getString("CPTCode");
				list.add(cpt);
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return list;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public static ArrayList<Surgery> getSurgery() {
		ArrayList<Surgery> list = new ArrayList<Surgery>();
		String query = "SELECT * FROM `Surgery`";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String cpt = "";
			String type = "";
			int cost = -1;
			while(rs.next()) {
				cpt = rs.getString("CPTCode");
				type = rs.getString("SurgeryType");
				cost = rs.getInt("CostOfSurgery");
				list.add(new Surgery(cpt, type, cost));
			}
			rs.close();
			statement.close();
			return list;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public static ArrayList<Performs> getPerforms() {
		ArrayList<Performs> list = new ArrayList<Performs>();
		String query = "SELECT * FROM `Performs`";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			String docUsername = "";
			String patUsername = "";
			String CPTcode = "";
			String surgeryStartTime = "";
			String surgeryEndTime = "";
			String anesthesiaStartTime = "";
			String complications = "";
			int noOfAssistants = -1;
			while(rs.next()) {
				CPTcode = rs.getString("CPTCode");
				docUsername = rs.getString("DocUsername");
				patUsername = rs.getString("PatientUsername");
				surgeryStartTime = rs.getString("SurgeryStartTime");
				surgeryEndTime = rs.getString("SurgeryEndTime");
				anesthesiaStartTime = rs.getString("AnesthesiaStartTime");
				complications = rs.getString("Complications");
				noOfAssistants = rs.getInt("NoOfAssistants");
				list.add(new Performs(docUsername, patUsername, CPTcode,
						surgeryStartTime, surgeryEndTime,
						anesthesiaStartTime, complications, noOfAssistants));
			}
			rs.close();
			statement.close();
			return list;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}
	
	public static ArrayList<Surgery> getSurgery(String cpt){ 
		ArrayList<Surgery> list = new ArrayList<Surgery>();
		String query = "SELECT * FROM `Surgery` WHERE `CPTCode`='"+cpt+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			while(rs.next()) {
				String cptCode = cpt;
				String surgeryType = rs.getString("SurgeryType");
				int cost = rs.getInt("CostOfSurgery");
				list.add(new Surgery(cptCode, surgeryType, cost));
			}
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return list;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} finally {
			DBC.closeConnection(connection);
		}
		return null;
	}

public static ArrayList<String> getSurgeryPreOpMed(String CPTCode) {
	ArrayList<String> preop = new ArrayList<String>();
	String query = "SELECT * FROM `SurgeryPreOpMeds WHERE `CPTCode` = '"+CPTCode+"'";
	
	try {
		connection = DBC.createConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = (ResultSet) statement.executeQuery(query);
		String preopmed = "";
		while(rs.next()) {
			preopmed = rs.getString("SurgeryPreOpMeds");
			preop.add(preopmed);
		}
		rs.close();
		statement.close();
		DBC.closeConnection(connection);
		return preop;
	} catch (Exception e) {
		System.err.println("Exception: " + e.getMessage());
	} finally {
		DBC.closeConnection(connection);
	}
	return null;
}

}
