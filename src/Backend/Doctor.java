package Backend;

public class Doctor extends User {
	
	private String licenseNo;
	private String fName;
	private String lName;
	private String dob;
	private String workphone;
	private String homeAddress;
	private String speciality;
	private String roomNo;

	public Doctor(String username, String password, String type) {
		super(username, password, "Doctor");
	}

	public Doctor(String username, String password, String type, String licenseNo, String fName, String lName, String dob, String workphone, String homeAddress, String speciality, String roomNo) {
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

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
}
