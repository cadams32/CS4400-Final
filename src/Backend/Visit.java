package Backend;

public class Visit {
	
	private int visitID;
	private String dateOfVisit;
	private int diastolicPressure;
	private int systolicPressure;
	private int billingAmount;
	
	private String docUsername;
	private String patUsername;
	
	public Visit(int visitID, String docUsername, String patUsername, String dateOfVisit, int diastolicPressure, int systolicPressure, int billingAmount) {
		this.visitID = visitID;
		this.docUsername = docUsername;
		this.patUsername = patUsername;
		this.dateOfVisit = dateOfVisit;
		this.diastolicPressure = diastolicPressure;
		this.systolicPressure = systolicPressure;
		this.billingAmount = billingAmount;
	}

	public int getVisitID() {
		return visitID;
	}

	public void setVisitID(int visitID) {
		this.visitID = visitID;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public int getDiastolicPressure() {
		return diastolicPressure;
	}

	public void setDiastolicPressure(int diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public int getSystolicPressure() {
		return systolicPressure;
	}

	public void setSystolicPressure(int systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public int getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(int billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getDocUsername() {
		return docUsername;
	}

	public void setDocUsername(String docUsername) {
		this.docUsername = docUsername;
	}

	public String getPatUsername() {
		return patUsername;
	}

	public void setPatUsername(String patUsername) {
		this.patUsername = patUsername;
	}
	
	

}
