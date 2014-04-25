package Backend;

public class Doctor extends User {
	
	private String licenseNo;
	private String fName;
	private String lName;
	private String dob;
	private String workphone;
	private String homeAddress;
	private String speciality;
	private int roomNo;

	public Doctor(String username, String password, String type, String licenseNo, String fName, String lName, String dob, String workphone, String homeAddress, String speciality, int roomNo) {
		super(username, password, "Doctor");
		this.setLicenseNo(licenseNo);
		this.setfName(fName);
		this.setlName(lName);
		this.setDob(dob);
		this.setWorkphone(workphone);
		this.setHomeAddress(homeAddress);
		this.setSpeciality(speciality);
		this.setRoomNo(roomNo);
	}

	public Doctor(String username, String fName2, String lName2, int roomNo2) {
		super(username, "password", "Doctor");
		this.fName = fName2;
		this.lName = lName2;
		this.roomNo = roomNo2;
	}
	
	public Doctor(String username, String fName, String lName) {
		super(username, "", "Doctor");
		this.fName = fName;
		this.lName = lName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	
	public String toString() {
		return username;
	}
}
