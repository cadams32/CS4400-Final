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
public class DatabaseHandler_K {
	
	private static Connection connection;
	private static DataBaseConnection DBC = new DataBaseConnection();
	
	public DatabaseHandler_K() {
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
			if(doesPatientExist(username)) {
				return "Patient";
			}
			if(doesDoctorExist(username)) {
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
			return false;
	}

	/**
	 * Insert New Patient_Allergies
	 * @param patientUsername
	 * @param allergy
	 */
	public static boolean addNewPatientAllergy(String patientUsername, String allergy) {
		if(!doesUsernameExist(patientUsername)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Patient_Allergies` (`PatientUsername` ,`Allergy`) VALUES ('"+patientUsername+"',  '"+allergy+"');";;
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
	public static boolean addNewDoctor(String username, String password, String licenseNo, String fName, String lName, String DOB, String homeAddress, String specialty, int roomNo) {
		addNewUser(username, password);	
		if(!doesUsernameExist(username)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Doctor` (`Username` ,`LicenseNo`, `FName`, `LName`, `DOB`, `WorkPhone`, `HomeAddress`, `Specialty`, `RoomNo`,) VALUES ('"+username+"',  '"+licenseNo+"', '"+fName+"', '"+lName+"', '"+DOB+"', '"+homeAddress+"', '"+specialty+"', '"+roomNo+"')";;
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
	 * Insert New Doctor_Available
	 * @param username
	 * @param to
	 * @param from
	 * @param day
	 */
	public static boolean addNewDoctorAvailable(String username, String to, String from, String day) {
		if(!doesUsernameExist(username)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Doctor_Available` (`Username`, `To`, `From`, `Day`) VALUES ('"+username+"', '"+to+"', '"+from+"', '"+day+"')";
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
	 * Insert New Doctor_Rating
	 * @param docUsername
	 * @param patUsername
	 * @param rating
	 */
	public static boolean addNewDoctorRating(String docUsername, String patUsername, int rating) {
		if(doesDoctorExist(docUsername) && doesPatientExist(patUsername)) {
			String query = "INSERT INTO  `cs4400_Group_37`.`Doctor_Rating` (`DocUsername` ,`PatientUsername` ,`Rating`) VALUES ('"+docUsername+"',  '"+patUsername+"',  '"+rating+"')";
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

	//TODO: Copy Pasta
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
		}
		return false;
	}
	
	public static boolean addNewSurgery(String CPTCode, String surgeryType, int costOfSurgery) {
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
		}
		return false;
	}
	
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
		}
		return false;
	}
	
	//Note: VisitID should be an auto-incrementing unsigned integer AKA: automatic
	public static boolean addNewVisit(int visitId, String docUsername, String patUsername, String dateOfVisit, int diastolic, int systolic, int billingAmount) {
		String query = "INSERT INTO `cs4400_Group_37`.`Visit` (`VisitID`, `DocUsername`, `PatientUsername`, `DateOfVisit`, `Diastolic`, `Systolic`, `BillingAmount`) VALUES ('" +
				visitId + "', '" + docUsername + "', '" + patUsername + "', '" + dateOfVisit + "', '" + diastolic + "', '" + systolic + "', '" + billingAmount + "')";
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
	
	public static boolean addNewVisitDiagnosis(int visitID, String diagnosis) {
		String query = "INSERT INTO `cs4400_Group_37`.`Visit_Diagnosis` (`VisitID`, `Diagnosis`) VALUES ('" +
				visitID + "', '" + diagnosis + "')";
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
	
	//Note: Ordered = Yes or No
	public static boolean addNewPrescription(int visitID, String medicineName, int dosage, int duration, String notes, String ordered) {
		String query = "INSERT INTO `cs4400_Group_37`.`Prescription` (`VisitID`, `MedicineName`, `Dosage`, `Duration`, `Notes`, `Ordered(Yes/No)`) VALUES ('" +
				visitID + "', '" + medicineName + "', '" + dosage + "', '" + duration + "', '" + notes + "', '" + ordered + "')";
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
	
	//Note: Status = Read or Unread
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
		}
		return false;
	}
	
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
		}
		return false;
	}
	
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
		}
		return false;
	}
	
	//Note: Status = Read or Unread
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
		}
		return false;
	}
	
	//Note: Status = Read or Unread
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
		}
		return false;
	}
	
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
	public static int getDoctorRating(String docUsername) { 
		String query = "SELECT AVG(`Rating`) as avg FROM `Doctor_Rating` WHERE `DocUsername`='"+docUsername+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			
			int i = Integer.parseInt(rs.getString("avg"));
			
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return i;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return -1;
	}
	//Returns list of availability
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
		}
		return null;
	}
	
	//Creating Order Prescription
	//get the Visits of a Patient
	public static ArrayList<Visit> getPatientVisits(String username) {
		ArrayList<Visit> list = new ArrayList<Visit>();
		String query = "SELECT * FROM `Visit` WHERE `PatientUsername`='"+username+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			while(rs.next()) {
				int visitID = rs.getInt("VisitID");
				String docUsername = rs.getString("DocUsername");
				String dateOfVisit = rs.getString("DateOfVisit");
				int diastolic = rs.getInt("Diastolic");
				int systolic = rs.getInt("Systolic");
				int billingAmount = rs.getInt("BillingAmount");
				
				list.add(new Visit(visitID, docUsername, null, dateOfVisit, diastolic, systolic, billingAmount));
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
	
	//get Prescriptions for a Visit (not Ordered)
	public static ArrayList<Prescription> getVisitPrescriptions(int visitID) {
		ArrayList<Prescription> list = new ArrayList<Prescription>();
		String query = "SELECT * FROM `Prescription` WHERE `VisitID`='"+visitID+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			while(rs.next()) {
				int visitId = rs.getInt("VisitID");
				String medicineName = rs.getString("MedicineName");
				int dosage = rs.getInt("Dosage");
				int duration = rs.getInt("Duration");
				String notes = rs.getString("Notes");
				String ordered = rs.getString("Ordered(Yes/No)");
				
				list.add(new Prescription(visitId, medicineName, dosage, duration, notes, ordered));
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
	
	public static int getVisitID(String patUsername) {
		String query = "SELECT * FROM `Visit` WHERE `PatientUsername`='"+patUsername+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			
			int visitId = rs.getInt("VisitID");
			
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return visitId;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return -1;
	}
	
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
	public static boolean updatePatientProfile(String patUsername, String patName, String dob, String gender, String address,
			String workPhone, String homePhone, String EContactName, String EContactPhone, int weight, int height, String annualInc) {
		
		String query = "UPDATE `cs4400_Group_37`.`Patient` SET `Name` = '" + patName + "', `DOB` = '" + dob + "', `Gender` = '" + gender + 
			"', `Address` = '" + address + "', `WorkPhone` = '" + workPhone + "', `HomePhone` = '" + homePhone + 
			"', `EContactName` = '" + EContactName + "', `EContactPhone` = '" + EContactPhone + "' " +
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
		}
		return false;
	}
	
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
	public static String getPatientPhoneNumber(String name) {
		String query = "SELECT `HomePhone` FROM `Patient` WHERE `Name`='"+name+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			
			String phone = rs.getString("HomePhone");
			
			rs.close();
			statement.close();
			DBC.closeConnection(connection);
			return phone;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return null;
	}
	
	public static ArrayList<String> getCPTCode(String patUsername) {
		ArrayList<String> list = new ArrayList<String>();
		String query = "SELECT `CPTCode` FROM `Performs` WHERE `PatientUsername`='"+patUsername+"'";
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			
			while(rs.next()) {
				String cpt = rs.getString("CPTCode");
				list.add(cpt);
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
	
	public static ArrayList<Surgery> getSurgery(String cpt){ 
		ArrayList<Surgery> list = new ArrayList<Surgery>();
		String query = "SELECT * FROM `Surgery` WHERE `CPTCode`='"+cpt+"'";
		
		try {
			connection = DBC.createConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = (ResultSet) statement.executeQuery(query);
			while(rs.next()) {
				String cptCode = cpt;
				String surgeryType = rs.getString("Type");
				int cost = rs.getInt("Cost");
				list.add(new Surgery(cptCode, surgeryType, cost));
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
	
	public static boolean updateDoctorRating(String docUsername, String patUsername, int rating) {
		String query = "UPDATE `cs4400_Group_37`.`Doctor_Rating` SET `Rating` = '" + rating + "' " +
				"WHERE `PatientUsername` = '" + patUsername + "' AND `DocUsername` = '" + docUsername + "'";
		
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
}