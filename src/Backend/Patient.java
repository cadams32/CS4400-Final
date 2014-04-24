package Backend;

public class Patient extends User{

	private String name;
	private String dob;
	private String gender;
	private String address;
	private String workphone;
	private String homephone;
	private String emerContactName;
	private String emerContactPhone;
	private String weight;
	private String height;
	//Annual Income
	private String cardNumber;
	private String annualIncome;
	
	public Patient(String username, String password, String type) {
		super(username, password, "Patient");
	}
	
	public Patient(String username, String name, String homePhone, String workPhone, String type) {
		super(username, "", type);
		this.name = name;
		this.homephone = homePhone;
		this.workphone = workPhone;
	}
	
	public Patient(String username, String name) {
		super(username, "", "Patient");
		this.name = name;
	}
	
	public Patient(String username, String name, String annualIncome, String type) {
		super(username, "", type);
		this.name = name;
		this.annualIncome = annualIncome;
	}
	
	public Patient(String username, String password, String name, String dob, String gender, String address, String workphone, String homephone, String emerContactName, String emerContactPhone, String weight, String height) {
		super(username, password, "Patient");
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.workphone = workphone;
		this.homephone = homephone;
		this.emerContactName = emerContactName;
		this.emerContactPhone = emerContactPhone;
		this.weight = weight;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getEmerContactName() {
		return emerContactName;
	}

	public void setEmerContactName(String emerContactName) {
		this.emerContactName = emerContactName;
	}

	public String getEmerContactPhone() {
		return emerContactPhone;
	}

	public void setEmerContactPhone(String emerContactPhone) {
		this.emerContactPhone = emerContactPhone;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	

}
